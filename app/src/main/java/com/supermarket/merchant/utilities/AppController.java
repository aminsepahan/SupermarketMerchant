package com.supermarket.merchant.utilities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.jaredrummler.android.device.DeviceName;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;
import com.supermarket.merchant.models.UserModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static com.supermarket.merchant.utilities.Constants.*;
import static com.supermarket.merchant.utilities.Snippets.*;

/**
 * Created by pooyasaberian on 11/26/15.
 * changed by Amin on 8/22/2016
 */

public class AppController extends Application {

    public static final String TAG = AppController.class
            .getSimpleName();

    private RequestQueue mRequestQueue;
    public static Context applicationContext = null;
    private static AppController mInstance;

    private Map<String, Object> mConfigs;

    private int mItemsInCartCount;

    private AtomicInteger mProductImageDownloaderId;

    UserModel currentUser;

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .setNotificationReceivedHandler(new OneSignal.NotificationReceivedHandler() {
                    @Override
                    public void notificationReceived(OSNotification notification) {
                        if(notification.payload.additionalData.has("notification_id")) {
                            String notificationId = "0";
                            try {
                                notificationId = notification.payload.additionalData.getString("notification_id");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            NetworkRequests.getRequest(getNotificationsDelivered(notificationId),
                                    new Interfaces.NetworkListeners() {
                                        @Override
                                        public void onResponse(String response) {

                                        }

                                        @Override
                                        public void onError(VolleyError error, String message, boolean isOnline) {

                                        }
                                    });

                        }
                    }
                })
                .setNotificationOpenedHandler(new OneSignal.NotificationOpenedHandler() {
                    @Override
                    public void notificationOpened(OSNotificationOpenResult result) {
                        if(result.notification.payload.additionalData != null && result.notification.payload.additionalData.has("notification_id") && result.action.type == OSNotificationAction.ActionType.Opened) {
                            String notificationId = "0";
                            try {
                                notificationId = result.notification.payload.additionalData.getString("notification_id");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                                NetworkRequests.getRequest(getNotificationsOpened(notificationId),
                                        new Interfaces.NetworkListeners() {
                                    @Override
                                    public void onResponse(String response) {

                                    }

                                    @Override
                                    public void onError(VolleyError error, String message, boolean isOnline) {

                                    }
                                });
                        }
                    }
                })
                .init();

        checkAppInstallation(false);

        applicationContext = getApplicationContext();
        mInstance = this;

        if (isSet(USER)){
            currentUser = JSON.parseObject(getSP(USER), UserModel.class);
        }

    }

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        setSP(USER, JSON.toJSONString(currentUser));
        setSP(USER_ID, currentUser.getId());
        this.currentUser = currentUser;
    }

    public void setCurrentUser(String user) {

        setSP(USER, user);
        currentUser = JSON.parseObject(user, UserModel.class);
        setSP(USER_ID, currentUser.getId());

    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(com.android.volley.Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }



    public int getAppVersionCode() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("App", e.getMessage(), e);
            return 0;
        }
    }


    public void checkAppInstallation(boolean force) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final int versionCode = getAppVersionCode();
        if (force || (versionCode > sharedPreferences.getInt("app_installation_app_version_code", 0))) {
            OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
                @Override
                public void idsAvailable(String userId, String registrationId) {
                    Log.d(LOG_TAG, "OneSignal userId: " + userId + ", registrationId: " + registrationId);
                    final JSONObject data = new JSONObject();
                    try {
                        data.put("token", userId);
                        data.put("os", "Android");
                        data.put("os_version", Build.VERSION.SDK_INT);
                        data.put("app", "client");
                        data.put("app_version", versionCode);
                        DeviceName.with(AppController.this).request(new DeviceName.Callback() {
                            @Override
                            public void onFinished(DeviceName.DeviceInfo info, Exception error) {
                                try {
                                    data.put("device_manufacture", info.manufacturer);
                                    data.put("device_market_name", info.marketName);
                                    data.put("device_name", info.getName());
                                    data.put("device_model", info.model);
                                    data.put("device_codename", info.codename);


                                    NetworkRequests.jsonPostRequest(getAppInstallation(), new Interfaces.NetworkListeners() {
                                        @Override
                                        public void onResponse(String response) {

                                        }

                                        @Override
                                        public void onError(VolleyError error, String message, boolean isOnline) {

                                        }
                                    }, data);
                                } catch (JSONException ignored) {
                                }
                            }
                        });

                    } catch (JSONException ignored) {
                    }
                }
            });

        }
    }

}

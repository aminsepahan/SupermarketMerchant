package com.supermarket.merchant.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.android.volley.VolleyError;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;
import com.google.firebase.iid.FirebaseInstanceId;
import com.supermarket.merchant.R;
import com.supermarket.merchant.utilities.AppController;
import com.supermarket.merchant.utilities.Interfaces;
import com.supermarket.merchant.utilities.NetworkRequests;

import org.json.JSONException;
import org.json.JSONObject;
import static com.supermarket.merchant.utilities.Constants.*;
import static com.supermarket.merchant.utilities.Snippets.*;
import static com.supermarket.merchant.utilities.Snippets.isSet;


public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    v.removeOnLayoutChangeListener(this);
                    exitReveal();
                }
            });
        } else {
            ViewAnimator.animate(findViewById(R.id.splashTitle)).translationX(50, 0).fadeIn().duration(300).startDelay(300)
                    .andAnimate(findViewById(R.id.splashLogo)).translationX(-50, 0).fadeIn().onStop(new AnimationListener.Stop() {
                @Override
                public void onStop() {
                    startProcess();
                }
            }).decelerate().start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startProcess() {
        checkForNewVersion();
        try {
            if (FirebaseInstanceId.getInstance().getToken() != null) {
                Log.d("Firebase token", FirebaseInstanceId.getInstance().getToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isSet(ACCESS_TOKEN)) {
            Log.d(LOG_TAG, "Access token : " + getSP(ACCESS_TOKEN));
        }

        openApp();
    }


    private void checkForNewVersion() {
        int versionCode = 0;
        try {
            PackageManager manager = AppController.getInstance().getPackageManager();
            PackageInfo info = manager.getPackageInfo(AppController.getInstance().getPackageName(), 0);
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        boolean shouldSend = false;
        if (isSet(LATEST_SENT_VERSION)) {
            if (versionCode > Integer.parseInt(getSP(LATEST_SENT_VERSION))) {
                shouldSend = true;
            }
        } else {
            shouldSend = true;
        }
        if (shouldSend) {
            String token = FirebaseInstanceId.getInstance().getToken();
            if (token == null) {
                token = "null";
            }
            JSONObject body = new JSONObject();
            try {
                body.put("fcm_token", token);
                body.put("os", "Android");
                body.put("version_code", String.valueOf(versionCode));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final int finalVersionCode = versionCode;
            NetworkRequests.jsonPutRequest(getAppInstallation(), new Interfaces.NetworkListeners() {
                @Override
                public void onResponse(String response) {
                    setSP(LATEST_SENT_VERSION, String.valueOf(finalVersionCode));
                }

                @Override
                public void onError(VolleyError error, String message, boolean isOnline) {

                }
            }, body);
        }
    }

    void exitReveal() {
        final View myView = findViewById(R.id.animatingView);
        View logo = findViewById(R.id.splashLogoBack);


        // get the center for the clipping circle
        int cx = logo.getLeft() + (logo.getMeasuredWidth() / 2);
        int cy = logo.getTop() + (logo.getMeasuredHeight() / 2);

        // get the initial radius for the clipping circle
        int initialRadius = myView.getHeight();

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

        anim.setDuration(800);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());


        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myView.setVisibility(View.INVISIBLE);
            }
        });
        ViewAnimator.animate(findViewById(R.id.splashTitle)).translationX(50, 0).fadeIn().duration(600).startDelay(300)
                .andAnimate(findViewById(R.id.splashLogo)).translationX(-50, 0).fadeIn().onStop(new AnimationListener.Stop() {
            @Override
            public void onStop() {
                startProcess();
            }
        }).decelerate().start();
        // start the animation
        anim.start();
    }

    private void openApp() {
        MainActivity.open(this, true);
        finish();
    }

}

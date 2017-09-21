package com.supermarket.merchant.utilities;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.supermarket.merchant.R;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.supermarket.merchant.utilities.Constants.*;
import static com.supermarket.merchant.utilities.Snippets.*;


/**
 * Created by Amin on 20/05/2016.
 *
 */
public class NetworkRequests {

    public static void getRequest(final String url, final Interfaces.NetworkListeners listener) {
        getRequest(url, listener, "");
    }

    public static void getRequest(final String url, final Interfaces.NetworkListeners listener, final String tag) {
        if (DEBUG) {
            Log.d(LOG_TAG, " url = " + url);
        }

        // creating volley string request
        final StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (!(response.contains("ا") || response.contains("ب") || response.contains("پ") ||
                        response.contains("ت") || response.contains("ث") || response.contains("ج")
                        || response.contains("چ") || response.contains("ح") || response.contains("خ")
                        || response.contains("د") || response.contains("ذ") || response.contains("ر")
                        || response.contains("ز") || response.contains("ژ") || response.contains("س")
                        || response.contains("ش") || response.contains("ص") || response.contains("ض")
                        || response.contains("ط") || response.contains("ظ") || response.contains("ع")
                        || response.contains("غ") || response.contains("ف") || response.contains("ق")
                        || response.contains("ک") || response.contains("گ") || response.contains("ل")
                        || response.contains("م") || response.contains("ن") || response.contains("و")
                        || response.contains("ه") || response.contains("ی"))) {
                    try {
                        response = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }


                if (DEBUG) {
                    Log.d(LOG_TAG, " response for url " + url + " ===== " + response);
                }
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                parseError(error, url, listener);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-agent", System.getProperty("http.agent"));
                if (isSet(ACCESS_TOKEN)) {
                    headers.put("Authorization", "Bearer " + getSP(ACCESS_TOKEN));
                }
                headers.put("OS", "Android");
                try {
                    PackageManager manager = AppController.getInstance().getPackageManager();
                    PackageInfo info = manager.getPackageInfo(AppController.getInstance().getPackageName(), 0);
                    headers.put("VersionCode", String.valueOf(info.versionCode));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                return headers;
            }
        };


        strReq.setRetryPolicy(new DefaultRetryPolicy(
                VOLLEY_TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        if (isOnline(AppController.applicationContext)) {
            AppController.getInstance().addToRequestQueue(strReq, "request");
        } else {
            listener.onError(null, AppController.getInstance().getString(R.string.you_are_offline), false);
        }

    }




    public static void deleteRequest(final String url, final Interfaces.NetworkListeners listener) {
        if (DEBUG) {
            Log.d(LOG_TAG, " url = " + url);
        }

        // creating volley string request
        final StringRequest strReq = new StringRequest(Request.Method.DELETE,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (!(response.contains("ا") || response.contains("ب") || response.contains("پ") ||
                        response.contains("ت") || response.contains("ث") || response.contains("ج")
                        || response.contains("چ") || response.contains("ح") || response.contains("خ")
                        || response.contains("د") || response.contains("ذ") || response.contains("ر")
                        || response.contains("ز") || response.contains("ژ") || response.contains("س")
                        || response.contains("ش") || response.contains("ص") || response.contains("ض")
                        || response.contains("ط") || response.contains("ظ") || response.contains("ع")
                        || response.contains("غ") || response.contains("ف") || response.contains("ق")
                        || response.contains("ک") || response.contains("گ") || response.contains("ل")
                        || response.contains("م") || response.contains("ن") || response.contains("و")
                        || response.contains("ه") || response.contains("ی"))) {
                    try {
                        response = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }


                if (DEBUG) {
                    Log.d(LOG_TAG, " response for url " + url + " ===== " + response);
                }
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                parseError(error, url, listener);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-agent", System.getProperty("http.agent"));
                if (isSet(ACCESS_TOKEN)) {
                    headers.put("Authorization", "Bearer " + getSP(ACCESS_TOKEN));
                }
                headers.put("OS", "Android");
                try {
                    PackageManager manager = AppController.getInstance().getPackageManager();
                    PackageInfo info = manager.getPackageInfo(AppController.getInstance().getPackageName(), 0);
                    headers.put("VersionCode", String.valueOf(info.versionCode));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                return headers;
            }
        };
        strReq.setRetryPolicy(new DefaultRetryPolicy(
                VOLLEY_TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        if (isOnline(AppController.applicationContext)) {
            AppController.getInstance().addToRequestQueue(strReq, "request");
        } else {
            listener.onError(null, AppController.getInstance().getString(R.string.you_are_offline), false);
        }

    }

    public static void getRequestWithKey(final String url, final Interfaces.NetworkListeners listener, final String key) {
        getRequest(url, new Interfaces.NetworkListeners() {
            @Override
            public void onResponse(String response) {
                String responseToSend = null;
                try {
                    com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(response);
                    responseToSend = jsonObject.get(key).toString();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
                if (responseToSend != null) {
                    listener.onResponse(responseToSend);
                } else {
                    listener.onError(null, "", true);
                }
            }

            @Override
            public void onError(VolleyError error, String message, boolean isOnline) {
                listener.onError(error, message, isOnline);
            }

        }, "");
    }

    public static void postRequest(final String url, final Interfaces.NetworkListeners listener,
                                   final String tag, final Map<String, String> postParams) {


        if (DEBUG) {
            Log.d(LOG_TAG, tag + " url = " + url);
        }
        StringRequest strReq = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if (!(response.contains("ا") || response.contains("ب") || response.contains("پ") ||
                        response.contains("ت") || response.contains("ث") || response.contains("ج")
                        || response.contains("چ") || response.contains("ح") || response.contains("خ")
                        || response.contains("د") || response.contains("ذ") || response.contains("ر")
                        || response.contains("ز") || response.contains("ژ") || response.contains("س")
                        || response.contains("ش") || response.contains("ص") || response.contains("ض")
                        || response.contains("ط") || response.contains("ظ") || response.contains("ع")
                        || response.contains("غ") || response.contains("ف") || response.contains("ق")
                        || response.contains("ک") || response.contains("گ") || response.contains("ل")
                        || response.contains("م") || response.contains("ن") || response.contains("و")
                        || response.contains("ه") || response.contains("ی"))) {
                    try {
                        response = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                if (DEBUG) {
                    Log.d(LOG_TAG, " response for url " + url + " ===== " + response);
                }
                listener.onResponse(response);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                parseError(error, url, listener);
            }
        }) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("User-agent", System.getProperty("http.agent"));
                if (isSet(ACCESS_TOKEN)) {
                    headers.put("Authorization", "Bearer " + getSP(ACCESS_TOKEN));
                }
                headers.put("OS", "Android");
                try {
                    PackageManager manager = AppController.getInstance().getPackageManager();
                    PackageInfo info = manager.getPackageInfo(AppController.getInstance().getPackageName(), 0);
                    headers.put("VersionCode", String.valueOf(info.versionCode));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                return headers;
            }
        };

        strReq.setRetryPolicy(new DefaultRetryPolicy(
                VOLLEY_TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        if (isOnline(AppController.applicationContext)) {
            AppController.getInstance().addToRequestQueue(strReq, "request");
        } else {
            listener.onError(null, AppController.getInstance().getString(R.string.you_are_offline), false);
        }

    }

    public static void jsonPostRequest(final String url, final Interfaces.NetworkListeners listener,
                                       final JSONObject jsonPostData) {

        if (DEBUG) {
            Log.d(LOG_TAG, url + "   and  post json is :  " + jsonPostData.toString());
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonPostData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObjectResponse) {

                        String response = jsonObjectResponse.toString();

                        if (!(response.contains("ا") || response.contains("ب") || response.contains("پ") ||
                                response.contains("ت") || response.contains("ث") || response.contains("ج")
                                || response.contains("چ") || response.contains("ح") || response.contains("خ")
                                || response.contains("د") || response.contains("ذ") || response.contains("ر")
                                || response.contains("ز") || response.contains("ژ") || response.contains("س")
                                || response.contains("ش") || response.contains("ص") || response.contains("ض")
                                || response.contains("ط") || response.contains("ظ") || response.contains("ع")
                                || response.contains("غ") || response.contains("ف") || response.contains("ق")
                                || response.contains("ک") || response.contains("گ") || response.contains("ل")
                                || response.contains("م") || response.contains("ن") || response.contains("و")
                                || response.contains("ه") || response.contains("ی"))) {
                            try {
                                response = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        if (DEBUG) {
                            Log.d(LOG_TAG, " response for url " + url + " ===== " + jsonObjectResponse);
                        }
                        listener.onResponse(jsonObjectResponse.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                parseError(error, url, listener);
            }
        }) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("OS", "Android");
                if (isSet(ACCESS_TOKEN)) {
                    headers.put("Authorization", "Bearer " + getSP(ACCESS_TOKEN));
                }
                try {
                    PackageManager manager = AppController.getInstance().getPackageManager();
                    PackageInfo info = manager.getPackageInfo(AppController.getInstance().getPackageName(), 0);
                    headers.put("VersionCode", String.valueOf(info.versionCode));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                return headers;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                VOLLEY_TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        if (isOnline(AppController.applicationContext)) {
            AppController.getInstance().addToRequestQueue(jsonObjectRequest, "request");
        } else {
            listener.onError(null, AppController.getInstance().getString(R.string.you_are_offline), false);
        }
    }

    public static void jsonPutRequest(final String url, final Interfaces.NetworkListeners listener, final JSONObject jsonPostData) {

        if (DEBUG) {
            Log.d(LOG_TAG, url + "   and  post json is :  " + jsonPostData.toString());
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonPostData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObjectResponse) {

                        String response = jsonObjectResponse.toString();

                        if (!(response.contains("ا") || response.contains("ب") || response.contains("پ") ||
                                response.contains("ت") || response.contains("ث") || response.contains("ج")
                                || response.contains("چ") || response.contains("ح") || response.contains("خ")
                                || response.contains("د") || response.contains("ذ") || response.contains("ر")
                                || response.contains("ز") || response.contains("ژ") || response.contains("س")
                                || response.contains("ش") || response.contains("ص") || response.contains("ض")
                                || response.contains("ط") || response.contains("ظ") || response.contains("ع")
                                || response.contains("غ") || response.contains("ف") || response.contains("ق")
                                || response.contains("ک") || response.contains("گ") || response.contains("ل")
                                || response.contains("م") || response.contains("ن") || response.contains("و")
                                || response.contains("ه") || response.contains("ی"))) {
                            try {
                                response = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        if (DEBUG) {
                            Log.d(LOG_TAG, " response for url " + url + " ===== " + jsonObjectResponse);
                        }
                        listener.onResponse(jsonObjectResponse.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                parseError(error, url, listener);
            }
        }) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("OS", "Android");
                if (isSet(ACCESS_TOKEN)) {
                    headers.put("Authorization", "Bearer " + getSP(ACCESS_TOKEN));
                }
                try {
                    PackageManager manager = AppController.getInstance().getPackageManager();
                    PackageInfo info = manager.getPackageInfo(AppController.getInstance().getPackageName(), 0);
                    headers.put("VersionCode", String.valueOf(info.versionCode));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                return headers;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                VOLLEY_TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        if (isOnline(AppController.applicationContext)) {
            AppController.getInstance().addToRequestQueue(jsonObjectRequest, "request");
        } else {
            listener.onError(null, AppController.getInstance().getString(R.string.you_are_offline), false);
        }
    }


    public static void jsonPutRequestWithKey(String url, final Interfaces.NetworkListeners listener, JSONObject jsonObject, final String key) {
        jsonPutRequest(url, new Interfaces.NetworkListeners() {
            @Override
            public void onResponse(String response) {
                String responseToSend = null;
                try {
                    com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(response);
                    responseToSend = jsonObject.get(key).toString();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
                if (responseToSend != null) {
                    listener.onResponse(responseToSend);
                } else {
                    listener.onError(null, "", true);
                }
            }

            @Override
            public void onError(VolleyError error, String message, boolean isOnline) {
                listener.onError(error, message, isOnline);
            }

        }, jsonObject);
    }

    public static void jsonPostRequestWithKey(String url, final Interfaces.NetworkListeners listener, JSONObject jsonObject, final String key) {
        jsonPostRequest(url, new Interfaces.NetworkListeners() {
            @Override
            public void onResponse(String response) {
                String responseToSend = null;
                try {
                    com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(response);
                    responseToSend = jsonObject.get(key).toString();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
                if (responseToSend != null) {
                    listener.onResponse(responseToSend);
                } else {
                    listener.onError(null, "", true);
                }
            }

            @Override
            public void onError(VolleyError error, String message, boolean isOnline) {
                listener.onError(error, message, isOnline);
            }

        }, jsonObject);
    }

    private static void parseError(VolleyError error, String url, Interfaces.NetworkListeners listener) {
        String message = "";
        if (error.networkResponse != null) {
            if (error.networkResponse.data != null) {
                message = new String(error.networkResponse.data);
            }
            message = message + error.networkResponse.statusCode;
            if (message.contains("html")){
                Log.d(LOG_TAG, " error for url " + url + message);
                message =  AppController.getInstance().getString(R.string.connection_error);
            }
        } else {
            message = AppController.getInstance().getString(R.string.connection_error);
        }
        if (DEBUG) {
            Log.d(LOG_TAG, " error for url " + url + message);
        }
        listener.onError(error, message, true);
    }
}

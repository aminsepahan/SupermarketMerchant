package com.supermarket.merchant.utilities;

import android.view.View;

import com.android.volley.VolleyError;
import com.supermarket.merchant.models.ProductModel;

/**
 * Created by Amin on 20/05/2016.
 * this the interface between fragments and main activity
 */
public class Interfaces {


    public interface NetworkListeners {
        public void onResponse(String response);
        public void onError(VolleyError error, String message, boolean isOnline);
    }


    public interface messageOkListener {
        public void onOkClicked();
    }

    public interface messageNoListener {
        public void onNoClicked();
    }

    public interface CallBack {
        public void call();
    }

    public interface ItemProductClickListener {
        public void onItemProductClicked(ProductModel model, View row);
    }

}

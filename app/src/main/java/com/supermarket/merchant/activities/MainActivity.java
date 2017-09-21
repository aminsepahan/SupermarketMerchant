package com.supermarket.merchant.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.supermarket.merchant.R;
import com.supermarket.merchant.utilities.Constants;

import static com.supermarket.merchant.utilities.Constants.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void open(Activity activity, boolean isFromSplash) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra(IS_FROM_SPLASH, isFromSplash);
        activity.startActivity(intent);
    }
}

package com.supermarket.merchant.activities;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;
import com.rey.material.widget.ProgressView;
import com.supermarket.merchant.R;
import com.supermarket.merchant.utilities.AppController;
import com.supermarket.merchant.utilities.Constants;
import com.supermarket.merchant.utilities.Interfaces;
import com.supermarket.merchant.utilities.NetworkRequests;
import com.supermarket.merchant.utilities.Snippets;

import org.json.JSONException;
import org.json.JSONObject;

import static com.supermarket.merchant.utilities.Constants.*;
import static com.supermarket.merchant.utilities.Snippets.*;

public class LoginActivity extends AppCompatActivity {

    EditText mobileEt;
    EditText codeEt;
    Button sendBtn;
    Button sendBtnOff;
    ProgressView sendProgress;
    View mobileLay;
    View codeLay;
    Button sendCodeAgainBtn;
    Button sendCodeAgainBtnOff;
    int status = 0;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobileLay = findViewById(R.id.mobileLay);
        codeLay = findViewById(R.id.verificationCodeLay);
        sendCodeAgainBtn = (Button) findViewById(R.id.sendCodeAgainBtn);
        sendCodeAgainBtnOff = (Button) findViewById(R.id.sendCodeAgainBtnOff);
        mobileEt = (EditText) findViewById(R.id.mobileEt);
        codeEt = (EditText) findViewById(R.id.verificationCodeEt);
        sendBtn = (Button) findViewById(R.id.saveBtn);
        sendBtnOff = (Button) findViewById(R.id.saveBtnOff);
        sendProgress = (ProgressView) findViewById(R.id.progress);

        showMobileNumberInput();
        setFontForActivity(this);
    }

    private void showMobileNumberInput() {
        mobileEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 11){
                    enableSendButton(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void enableSendButton(boolean showOrHide) {
        if (showOrHide){
            ViewAnimator.animate(sendBtn).fadeIn().duration(200).start();
            sendBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendButtonClicked();
                }
            });
        } else {
            ViewAnimator.animate(sendBtn).fadeOut().duration(200).start();
            sendBtn.setOnClickListener(null);
        }
    }

    private void sendButtonClicked() {
        if (status == 0){
            sendMobileNumber();
        }
    }

    private void sendMobileNumber() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", mobileEt.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendProgress.start();
        sendBtn.setText("");
        sendBtnOff.setText("");
        NetworkRequests.jsonPostRequest(getLoginUrl(), new Interfaces.NetworkListeners() {
            @Override
            public void onResponse(String response) {

                sendProgress.stop();
                sendBtn.setText(getString(R.string.send));
                sendBtnOff.setText(getString(R.string.send));
                try {
                    com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(response);
                    AppController.getInstance().setCurrentUser(jsonObject.get("user").toString());
                    if (jsonObject.containsKey("code")) {
                        codeEt.setText(String.valueOf(jsonObject.getInteger("code")));
                    }
                    ViewAnimator.animate(mobileLay)
                            .translationX(0, -mobileLay.getWidth())
                            .fadeOut()
                            .andAnimate(codeLay)
                            .translationX(codeLay.getWidth(), 0)
                            .fadeIn()
                            .duration(300)
                            .decelerate()
                            .onStart(new AnimationListener.Start() {
                                @Override
                                public void onStart() {
                                    codeLay.setVisibility(View.VISIBLE);
                                }
                            })
                            .start();;
                    setupTimer();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError error, String message, boolean isOnline) {

            }
        }, jsonObject);
    }


    public void setupTimer() {
        findViewById(R.id.sendCodeAgainLay).setVisibility(View.VISIBLE);
        if (countDownTimer == null) {
            sendCodeAgainBtn.setAlpha(0);
            sendCodeAgainBtn.setOnClickListener(null);
            countDownTimer = new CountDownTimer(180000, 1000) {
                public void onTick(long millisUntilFinished) {
                    long secondsUntilFinish = millisUntilFinished / 1000;
                    long minutes = secondsUntilFinish / 60;
                    long seconds = secondsUntilFinish - (minutes * 60);
                    String remainingString;
                    if (minutes == 0) {
                        remainingString = "00" + ":";
                    } else {
                        remainingString = minutes + ":";
                    }
                    if (seconds < 10) {
                        remainingString += "0";
                    }
                    remainingString += seconds;
                    sendCodeAgainBtnOff.setText(getString(R.string.send_again) + " (" + remainingString + ")");
                }

                public void onFinish() {
                    countDownTimer = null;
                    sendCodeAgainBtnOff.setText(getString(R.string.send_again));
                    ViewAnimator.animate(sendCodeAgainBtn).alpha(0, 1).duration(300).start();
                    sendCodeAgainBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendCodeAgain();
                        }
                    });
                }
            };
            countDownTimer.start();
        }
    }

    private void sendCodeAgain() {

    }
}

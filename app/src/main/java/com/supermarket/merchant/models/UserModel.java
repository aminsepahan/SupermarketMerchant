package com.supermarket.merchant.models;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Amin on 05/05/2017.
 *
 */

public class UserModel {

    @JSONField(name = "_id")
    String id;

    String mobile;
    String name;

    @JSONField(name = "is_active")
    boolean isActive;

    @JSONField(name = "signup_is_completed")
    boolean signupIsCompleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isSignupIsCompleted() {
        return signupIsCompleted;
    }

    public void setSignupIsCompleted(boolean signupIsCompleted) {
        this.signupIsCompleted = signupIsCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
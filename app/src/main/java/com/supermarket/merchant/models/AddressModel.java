package com.supermarket.merchant.models;

import android.view.View;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Amin on 27/02/2017.
 */

public class AddressModel {

    @JSONField(name = "_id")
    String id;

    @JSONField(name = "user_id")
    String userId;

    @JSONField(name = "district_name")
    String districtName;

    double lat;
    double lng;

    @JSONField(name = "full_address")
    String fullAddress;
    String address;
    String mobile;
    transient View row;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public View getRow() {
        return row;
    }

    public void setRow(View row) {
        this.row = row;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

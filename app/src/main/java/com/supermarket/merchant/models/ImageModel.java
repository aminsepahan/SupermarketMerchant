package com.supermarket.merchant.models;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Amin on 4/27/2017.
 */

public class ImageModel {

    String url;

    @JSONField(name = "original_url")
    String originalUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}

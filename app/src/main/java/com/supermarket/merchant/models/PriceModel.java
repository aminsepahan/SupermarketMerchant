package com.supermarket.merchant.models;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Amin on 26/04/2017.
 */

public class PriceModel {

    @JSONField(name = "is_on_sale")
    boolean isOnSale;

    @JSONField(name = "list_price")
    Long listPrice;

    @JSONField(name = "sale_price")
    Long salePrice;

    @JSONField(name = "discount_percent")
    int discountPercent;


    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public Long getListPrice() {
        return listPrice;
    }

    public void setListPrice(Long listPrice) {
        this.listPrice = listPrice;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}

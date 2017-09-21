package com.supermarket.merchant.models;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Amin on 11/06/2017.
 */

public class LineItemModel {

    @JSONField(name = "_id")
    String id;

    @JSONField(name = "product_id")
    String productId;

    @JSONField(name = "product_name")
    String productName;

    @JSONField(name = "product_size")
    String productSize;

    @JSONField(name = "product_thumbnail_url")
    String thumbnailUrl;

    int qty;

    @JSONField(name = "has_error")
    boolean hasError;

    @JSONField(name = "is_on_sale")
    boolean isOnSale;

    @JSONField(name = "product_exists")
    boolean productExists;

    @JSONField(name = "list_price")
    long listPrice;

    @JSONField(name = "sale_price")
    long salePrice;

    long total;
    long discount;
    long subtotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public boolean isProductExists() {
        return productExists;
    }

    public void setProductExists(boolean productExists) {
        this.productExists = productExists;
    }

    public long getListPrice() {
        return listPrice;
    }

    public void setListPrice(long listPrice) {
        this.listPrice = listPrice;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
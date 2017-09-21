package com.supermarket.merchant.models;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Amin on 11/06/2017.
 */

public class OrderModel {

    @JSONField(name = "line_items")
    List<LineItemModel> lineItems;

    @JSONField(name = "order_number")
    long orderNumber;

    @JSONField(name = "shipping_address_id")
    String shippingAddressId;

    @JSONField(name = "status_name")
    String statusName;

    @JSONField(name = "created_at_persian")
    String createdAtPersian;

    @JSONField(name = "shipping_address")
    AddressModel shippingAddress;

    ShopModel shop;


    long total;
    long discount;
    long tax;
    long shipping;
    long subtotal;
    String status;

    public List<LineItemModel> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemModel> lineItems) {
        this.lineItems = lineItems;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(String shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreatedAtPersian() {
        return createdAtPersian;
    }

    public void setCreatedAtPersian(String createdAtPersian) {
        this.createdAtPersian = createdAtPersian;
    }

    public AddressModel getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressModel shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public ShopModel getShop() {
        return shop;
    }

    public void setShop(ShopModel shop) {
        this.shop = shop;
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

    public long getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public long getShipping() {
        return shipping;
    }

    public void setShipping(long shipping) {
        this.shipping = shipping;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
package com.supermarket.merchant.models;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Amin on 4/27/2017.
 */

public class InventoryModel {

    @JSONField(name = "is_in_stock")
    boolean isInStock;

    @JSONField(name = "manage_stock")
    boolean manageStock;

    @JSONField(name = "min_sale_qty")
    int minSaleQty;

    @JSONField(name = "max_sale_qty")
    int maxSaleQty;

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public boolean isManageStock() {
        return manageStock;
    }

    public void setManageStock(boolean manageStock) {
        this.manageStock = manageStock;
    }

    public int getMinSaleQty() {
        return minSaleQty;
    }

    public void setMinSaleQty(int minSaleQty) {
        this.minSaleQty = minSaleQty;
    }

    public int getMaxSaleQty() {
        return maxSaleQty;
    }

    public void setMaxSaleQty(int maxSaleQty) {
        this.maxSaleQty = maxSaleQty;
    }
}

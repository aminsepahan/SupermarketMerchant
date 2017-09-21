package com.supermarket.merchant.models;

import android.view.View;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Amin on 26/04/2017.
 */

public class ProductModel {
    String id;
    PriceModel pricing;
    InventoryModel inventory;

    List<ImageModel> images;

    @JSONField(name = "category_id")
    String categoryId;

    @JSONField(name = "category_slug")
    String categorySlug;

    @JSONField(name = "category_name")
    String categoryName;

    @JSONField(name = "category_ids")
    List<String> categoryIds;

    @JSONField(name = "category_names")
    List<String> categoryNames;

    @JSONField(name = "category_slugs")
    List<String> categorySlugs;

    @JSONField(name = "attribute_set_id")
    String attributeSetId;

    @JSONField(name = "brand_id")
    String brandId;

    @JSONField(name = "brand_name")
    String brandName;
    String details;
    String ingredients;
    String warnings;
    String directions;

    boolean liked;

    @JSONField(name = "is_favored")
    boolean isFavored;

    @JSONField(name = "is_in_cart")
    boolean isInCart;

    @JSONField(name = "in_cart_qty")
    int inCartQty;

    @JSONField(name = "is_active")
    boolean isActive;

    @JSONField(name = "is_visible")
    boolean isVisible;

    String type;
    String name;
    String size;
    boolean kosher;


    @JSONField(name = "low_fat")
    boolean lowFat;

    @JSONField(name = "fat_free")
    boolean fatFree;
    boolean organic;

    @JSONField(name = "sugar_free")
    boolean sugarFree;
    boolean vegan;
    boolean vegetarian;

    @JSONField(name = "thumbnail_url")
    String thumbnailUrl;

    @JSONField(name = "is_in_stock")
    boolean isInStock;

    transient View row;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PriceModel getPricing() {
        return pricing;
    }

    public void setPricing(PriceModel pricing) {
        this.pricing = pricing;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<String> getCategorySlugs() {
        return categorySlugs;
    }

    public void setCategorySlugs(List<String> categorySlugs) {
        this.categorySlugs = categorySlugs;
    }

    public String getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public boolean isLowFat() {
        return lowFat;
    }

    public void setLowFat(boolean lowFat) {
        this.lowFat = lowFat;
    }

    public boolean isFatFree() {
        return fatFree;
    }

    public void setFatFree(boolean fatFree) {
        this.fatFree = fatFree;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    public boolean isSugarFree() {
        return sugarFree;
    }

    public void setSugarFree(boolean sugarFree) {
        this.sugarFree = sugarFree;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public InventoryModel getInventory() {
        return inventory;
    }

    public void setInventory(InventoryModel inventory) {
        this.inventory = inventory;
    }

    public List<ImageModel> getImages() {
        return images;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isFavored() {
        return isFavored;
    }

    public void setFavored(boolean favored) {
        isFavored = favored;
    }

    public boolean isInCart() {
        return isInCart;
    }

    public void setInCart(boolean inCart) {
        isInCart = inCart;
    }

    public int getInCartQty() {
        return inCartQty;
    }

    public void setInCartQty(int inCartQty) {
        this.inCartQty = inCartQty;
    }

    public View getRow() {
        return row;
    }

    public void setRow(View row) {
        this.row = row;
    }
}

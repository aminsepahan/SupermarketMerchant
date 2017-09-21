package com.supermarket.merchant.utilities;

import android.net.Uri;

import com.supermarket.merchant.R;

import java.text.DecimalFormat;

/**
 * Created by Amin on 11/16/2014.
 * be cause this app will be used for different websites, it needs different Constants too
 */
public class Constants {

    public static boolean clientOrRealtor = true;

    // LINKS AND URLs:

    public static final String BASIC_AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJzdWIiOiI1NTJiOTRiYjI3NmQ0ZDA3MzI4YjU1N2IiLCJpc3MiOiJodHRwOlwvXC9tb3NoYXZlci5jb21cL2FtbGFrXC9hcGlcL3YxXC9yZWFsdG9yc1wvdmVyaWZ5IiwiaWF0IjoiMTQ4MTE5MjgzNSIsImV4cCI6IjIwNDAyNzkyODM1IiwibmJmIjoiMTQ4MTE5MjgzNSIsImp0aSI6ImY1MmEzZDY4NGJjZjIxN2MyNjIzYWIwMDVjYmVhYWU4In0.Nzc2YjI3MzZjNjZlMDViOTUxZDY3ZWE3OTE4NDY2ZTA0OTE3YjZmZGFhYzc0ZTRjOWI1NWYxMmRhMTIzNTFkMQ";
    public static final String API_HOST = "http://api.123website.ca/api/merchant/v1";
    public static final String DEFAULT_IMAGE = "http://moshaver.com/amlak/images/property-no-image.jpg";

    public static Uri.Builder getApiHttpUrlBuilder(boolean withVersion) {
        Uri.Builder builder = Uri.parse(API_HOST).buildUpon();
        return builder;
    }

    public static String getCategoriesUrl(String parentId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("categories")
                .appendQueryParameter("parent_id", parentId)
                .build();
        return url.toString();
    }

    public static String getCategoriesUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("categories")
                .build();
        return url.toString();
    }

    public static String getProductUrl(String productId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("products")
                .appendPath(productId)
                .build();
        return url.toString();
    }

    public static String getProductListOfCatUrl(String catId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("products")
                .appendQueryParameter("category_id", catId)
                .build();
        return url.toString();
    }

    public static String getHomeListsUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("home")
                .build();
        return url.toString();
    }

    public static String getSearchUrl(String searchPhrase) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("search")
                .appendQueryParameter("q", searchPhrase)
                .build();
        return url.toString();
    }

    public static String getCartUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-cart")
                .build();
        return url.toString();
    }

    public static String getLoginUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("auth/login")
                .build();
        return url.toString();
    }

    public static String getVerifyCodeUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("auth/verify")
                .build();
        return url.toString();
    }

    public static String getCompleteSignUpUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("users")
                .appendPath("complete-sign-up")
                .build();
        return url.toString();
    }

    public static String getAddToCartUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-cart")
                .appendPath("add-to-cart")
                .build();
        return url.toString();
    }

    public static String getUpdateCartUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-cart")
                .appendPath("update-qty")
                .build();
        return url.toString();
    }

    public static String getDeleteCartUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-cart")
                .appendPath("remove-from-cart")
                .build();
        return url.toString();
    }

    public static String getDeleteAddressUrl(String addressId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("users")
                .appendPath("addresses")
                .appendPath(addressId)
                .build();
        return url.toString();
    }

    public static String getUpdateAddressUrl(String addressId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("users")
                .appendPath("addresses")
                .appendPath(addressId)
                .build();
        return url.toString();
    }

    public static String getCreateAddressUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("users")
                .appendPath("addresses")
                .build();
        return url.toString();
    }

    public static String getAddressesUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("users")
                .appendPath("addresses")
                .build();
        return url.toString();
    }

    public static String getDistrictListUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("district")
                .build();
        return url.toString();
    }

    public static String getAddProductToFavoritesUrl(boolean isLike) {
        Uri url;
        if (isLike) {
            url = getApiHttpUrlBuilder(true)
                    .appendPath("favorite-products")
                    .appendPath("add-product")
                    .build();
        } else {
            url = getApiHttpUrlBuilder(true)
                    .appendPath("favorite-products")
                    .appendPath("remove-product")
                    .build();
        }
        return url.toString();
    }


    public static String getFavoritesUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("favorite-products")
                .build();
        return url.toString();
    }

    public static String getShoppingListsUrlForProduct() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-lists")
                .build();
        return url.toString();
    }

    public static String getShoppingListsUrl(String shoppingListId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-lists")
                .appendPath(shoppingListId)
                .build();
        return url.toString();
    }

    public static String getCreateShoppingListsUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-lists")
                .build();
        return url.toString();
    }

    public static String getAddToShoppingListsUrl(String shoppingListId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-lists")
                .appendPath(shoppingListId)
                .appendPath("add-product")
                .build();
        return url.toString();
    }

    public static String getRemoveFromShoppingListsUrl(String shoppingListId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-lists")
                .appendPath(shoppingListId)
                .appendPath("remove-product")
                .build();
        return url.toString();
    }

    public static String getShoppingListsUrlForProduct(String productId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("shopping-lists")
                .appendQueryParameter("product_id", productId)
                .build();
        return url.toString();
    }

    public static String getCreateOrderUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("orders")
                .build();
        return url.toString();
    }

    public static String getOrderListUrl() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("orders")
                .build();
        return url.toString();
    }

    public static String getAppInstallation() {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("app-installations")
                .build();
        return url.toString();
    }

    public static String getNotificationsOpened(String notificationId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("notifications")
                .appendPath(notificationId)
                .appendPath("opened")
                .build();
        return url.toString();
    }

    public static String getNotificationsDelivered(String notificationId) {
        Uri url = getApiHttpUrlBuilder(true)
                .appendPath("notifications")
                .appendPath(notificationId)
                .appendPath("delivered")
                .build();
        return url.toString();
    }

    public static String getMapSearchAPi(double lat, double lng) {
        Uri.Builder builder = Uri.parse("https://maps.googleapis.com/maps/api/geocode/json").buildUpon();
        builder.appendQueryParameter("latlng", lat + "," + lng)
                .appendQueryParameter("key", "AIzaSyBu7JSpqiRZQTGxGsOdT0LWir0ubxpcy7Y")
                .appendQueryParameter("region", "ir")
                .appendQueryParameter("language", "fa");
        return builder.build().toString();
    }

    public static String getMapSearchAPi(double lat, double lng, String query) {
//        https://maps.googleapis.com/maps/api/place/textsearch/json?location=35.6892,51.3890&query=%D8%AD%D8%B3%D9%86%20%D8%B3%DB%8C%D9%81&language=fa&key=AIzaSyBu7JSpqiRZQTGxGsOdT0LWir0ubxpcy7Y&radius=1000
        Uri.Builder builder = Uri.parse("https://maps.googleapis.com/maps/api/place/textsearch/json").buildUpon();
        builder.appendQueryParameter("location", lat + "," + lng)
                .appendQueryParameter("key", "AIzaSyBu7JSpqiRZQTGxGsOdT0LWir0ubxpcy7Y")
                .appendQueryParameter("language", "fa")
                .appendQueryParameter("region", "ir")
                .appendQueryParameter("radius", "1000")
                .appendQueryParameter("query", query);
        return builder.build().toString();
    }


    public static String GET_PRODUCT_LIST = "GET_PRODUCT_LIST";
    public static String API_DATA_KEY = "data";


    //AMIN: Name Strings:
    public static String LOG_TAG = "****AMIN ** DEBUG****";
    private static final String IMAGE_DIRECTORY_NAME = "Moshaver";

    // SYNC and OFFLINE lists
    public static final String IS_DATABASE_LOADED = "IS_DATABASE_LOADED";
    public static final String DELETE_PROPERTY_LIST = "DELETE_PROPERTY_LIST";
    public static final String TIME_STAMP = "TIME_STAMP";
    public static final int OFFLINE_EDIT = 5487;
    public static final String AUTHORITY = "com.moshaver.android.utilities.Provider";
    public static final String AUTHTOKEN_TYPE_REALTOR = "AUTHTOKEN_TYPE_REALTOR";
    public static final String SYNC_INTENT_ACTION = "SYNC_INTENT_ACTION";
    public static final String SYNCING_STATUS = "SYNCING_STATUS";
    public static final String SYNCING_MESSAGE = "SYNCING_MESSAGE";
    public static final int RUNNING = 1;
    public static final int FINISHED = 2;
    public static final int ERROR = 3;
    public static final int STARTED = 4;


    public static final String ORDER_RECENT = "recent";
    public static final String ORDER_PRICE_ASC = "price_asc";
    public static final String ORDER_PRICE_DESC = "price_desc";
    public static final String ORDER_BEST_SALES = "best_sales";


    //AMIN Shared Pref Keys
    public static String SP_FILE_NAME_BASE = "sp_file_base";
    public static String FALSE = "FALSE";
    public static String TRUE = "TRUE";
    public static String REGIONS = "REGIONS";
    public static String PROPERTY_FORM = "PROPERTY_FORM";
    public static String SEARCH_FORM = "SEARCH_FORM";

    //AMIN INTENT KEYS:
    public static String PARENT_ID = "PARENT_ID";
    public static String POSITION_MENU = "POSITION_MENU";
    public static String TITLE = "TITLE";
    public static String TYPE = "TYPE";
    public static String PRICE = "PRICE";
    public static String SALE_PRICE = "SALE_PRICE";
    public static String SALE = "SALE";
    public static String SLOGAN = "SLOGAN";
    public static String LOGO = "LOGO";
    public static String HEADER = "HEADER";
    public static String OFFLINE_MODE = "OFFLINE_MODE";
    public static String BOOKMARK_LIST = "BOOKMARK_LIST";
    public static String DISTRICT_LIST = "DISTRICT_LIST";
    public static String BOOKMARK_NUM = "BOOKMARK_NUM";
    public static String LINK = "LINK";
    public static String POSITION = "POSITION";
    public static String COUNT = "COUNT";
    public static String MAX_NUMBER = "MAX_NUMBER";
    public static String IMAGE = "IMAGE";
    public static String MODEL = "MODEL";
    public static String USER = "USER";
    public static String LATEST_SENT_VERSION = "LATEST_SENT_VERSION";
    public static String IS_LOGGED_IN = "IS_LOGGED_IN";
    public static String LIKED = "LIKED";
    public static String IS_FROM_SPLASH = "IS_FROM_SPLASH";
    public static String IS_SHOPPING_LIST = "IS_SHOPPING_LIST";
    public static String USER_ID = "USER_ID";
    public static String USER_NAME = "USER_NAME";
    public static String AGENCY_NAME = "AGENCY_NAME";
    public static String LOGIN_COMPLETE = "LOGIN_COMPLETE";
    public static String ID = "ID";
    public final static String LATITUDE = "LATITUDE";
    public final static String LONGITUDE = "LONGITUDE";
    public static String SPLASH_SCREEN = "SPLASH_SCREEN";
    public static String IS_EDIT = "IS_EDIT";
    public static String FRESH_START = "FRESH_START";
    public static String ACCESS_TOKEN = "ACCESS_TOKEN";
    public static String FIREBASE_TOKEN = "ACCESS_TOKEN";
    public static String APP_INSTALLATION_ID = "APP_INSTALLATION_ID";
    public static String SALE_OR_RENT = "SALE_OR_RENT";
    public static String ADD_ACCOUNT = "ADD_ACCOUNT";
    public static String PLAY_SERVICES_ON_OR_OFF = "PLAY_SERVICES_ON_OR_OFF";
    public static String LOCATION_PERMISSION = "LOCATION_PERMISSION";
    public static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int GALLERY_PICK_IMAGE_REQUEST_CODE = 101;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;


    //AMIN Numbers:
    public static final int EDIT_REQ_CODE = 100;
    public static final int NEW_REQ_CODE = 101;
    public static final int PRODUCT_ADD_TO_CART = 102;
    public static final int COMPLETE_ORDER = 103;
    public static final int GPS_SETTING_REQUEST_CODE = 9002;
    public static final int SEARCH_MAP = 9003;
    public static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 9004;
    public static final int VOLLEY_TIME_OUT = 50000;
    public static final int ITEM_IN_PAGE_COUNT = 10;
    public static final int NOTIFICATION_ID = 900;
    public static final int NOTIFICATION_CHECK_PERIOD = 30 * 60 * 1000;
    public static boolean DEBUG = true;


    public static String formatPrice(String num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(Long.valueOf(num));
    }

    public static String formatPrice(double num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(num);
    }

    public static String formatPrice(Long num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(num);
    }

    public static String formatPriceWithCurrency(Long num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(num) + " " + AppController.getInstance().getString(R.string.toman);
    }

    public static String formatPriceWithCurrency(String num) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(Long.valueOf(num)) + " " + AppController.getInstance().getString(R.string.toman);
    }
}

package com.gpk.mobilenice.httprequest;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class NetworkConnectionManager {

    private OkHttpClient client = new OkHttpClient();
    private Request request;

    public void callServer(String url ,Callback callback){
        request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

}

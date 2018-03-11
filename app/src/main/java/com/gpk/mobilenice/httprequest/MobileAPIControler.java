package com.gpk.mobilenice.httprequest;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gpk.mobilenice.model.MobileDetailModel;
import com.gpk.mobilenice.model.MobileModel;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class MobileAPIControler {
    NetworkConnectionManager networkConnectionManager = new NetworkConnectionManager();

    public void getMobileList(final OnGetMobileListener onGetMobileListener) {
        String url = Url.URL_MOBILE_LIST;
        networkConnectionManager.callServer(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onGetMobileListener.onFailure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responses = response.body().string();
                Type listType = new TypeToken<List<MobileModel>>(){}.getType();
                List<MobileModel> mobileList = new Gson().fromJson(responses, listType);
                onGetMobileListener.onSuccess(mobileList);
            }
        });

    }

    public void getMobileDetail(String mobileId, final OnGetMobileDetailListener onGetMobileDetailListener) {
        String url = String.format(Url.URL_MOBILE_DETAIL, mobileId);
        networkConnectionManager.callServer(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onGetMobileDetailListener.onFailure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responses = response.body().string();
                Type listType = new TypeToken<List<MobileDetailModel>>(){}.getType();
                List<MobileDetailModel> mobileList = new Gson().fromJson(responses, listType);
                onGetMobileDetailListener.onSuccess(mobileList);
            }
        });

    }

    public interface OnGetMobileListener {
        void onSuccess(List<MobileModel> mobileList);

        void onFailure();
    }

    public interface OnGetMobileDetailListener {
        void onSuccess(List<MobileDetailModel> mobileDetailModels);

        void onFailure();
    }

}

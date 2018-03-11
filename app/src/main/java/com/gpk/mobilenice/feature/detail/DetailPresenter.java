package com.gpk.mobilenice.feature.detail;

import android.content.Context;

import com.gpk.mobilenice.httprequest.MobileAPIControler;
import com.gpk.mobilenice.model.MobileDetailModel;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class DetailPresenter implements DetailInterface.Presenter {
    private MobileAPIControler apiControler;
    private DetailInterface.View view;

    public DetailPresenter(DetailInterface.View view) {
        this.view = view;
        apiControler = new MobileAPIControler();
    }

    @Override
    public void loadDetailData(int id) {
        apiControler.getMobileDetail(String.valueOf(id), new MobileAPIControler.OnGetMobileDetailListener() {
            @Override
            public void onSuccess(List<MobileDetailModel> mobileDetailModels) {
                view.updateDetailData(mobileDetailModels);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}

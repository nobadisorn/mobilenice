package com.gpk.mobilenice.feature.main.fragment.mobilelist;

import com.gpk.mobilenice.httprequest.MobileAPIControler;
import com.gpk.mobilenice.model.MobileModel;

import java.util.List;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class MobileListPresenter implements MobileListInterface.Presenter {

    private MobileAPIControler apiControler;
    private MobileListInterface.View view;

    public MobileListPresenter(MobileListInterface.View view) {
        apiControler = new MobileAPIControler();
        this.view = view;
    }

    @Override
    public void getMobileList() {
        apiControler.getMobileList(new MobileAPIControler.OnGetMobileListener() {
            @Override
            public void onSuccess(List<MobileModel> mobileList) {
                view.updateMobileListData(mobileList);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}

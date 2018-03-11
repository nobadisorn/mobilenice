package com.gpk.mobilenice.feature.detail;

import com.gpk.mobilenice.model.MobileDetailModel;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public interface DetailInterface {
    interface View{
        void updateDetailData(List<MobileDetailModel> mobileDetailModels);
    }

    interface Presenter{
        void loadDetailData(int id);
    }
}

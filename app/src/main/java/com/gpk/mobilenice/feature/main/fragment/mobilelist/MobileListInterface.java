package com.gpk.mobilenice.feature.main.fragment.mobilelist;

import com.gpk.mobilenice.model.MobileModel;

import java.util.List;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public interface MobileListInterface  {
    interface View{
        void updateMobileListData(List<MobileModel> mobileList);
    }

    interface Presenter{
        void getMobileList();
    }
}

package com.gpk.mobilenice.feature.main;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public interface MainInterface {
    interface View{
        void updateDataMobileList();
    }

    interface Presenter{
        void getMobileList();

    }
}

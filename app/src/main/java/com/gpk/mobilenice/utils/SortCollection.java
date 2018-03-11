package com.gpk.mobilenice.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gpk.mobilenice.common.Constant;
import com.gpk.mobilenice.model.MobileModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class SortCollection {

    private Context context;
    private SharedPerfsUtils perfsUtils;

    public SortCollection(Context context) {
        this.context = context;
        perfsUtils = new SharedPerfsUtils(context);
    }

    public void sortData(List<MobileModel> modelList){
        Collections.sort(modelList , new SortMobileList());
    }

    private class SortMobileList implements Comparator<MobileModel> {
        @Override
        public int compare(MobileModel mobileModel, MobileModel t1) {
            if (perfsUtils.getSortBy() == Constant.SORT_LOW_TO_HIGH){
                return mobileModel.getPrice() < t1.getPrice() ? -1 : 1;
            }
            else if (perfsUtils.getSortBy() == Constant.SORT_HIGH_TO_LOW){
                return mobileModel.getPrice() > t1.getPrice() ? -1 : 1;
            }
            else {
                return mobileModel.getRating() > t1.getRating() ? -1 : 1;
            }

        }
    }
}

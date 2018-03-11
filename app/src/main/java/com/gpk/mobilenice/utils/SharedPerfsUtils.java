package com.gpk.mobilenice.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.gpk.mobilenice.common.Constant;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class SharedPerfsUtils {
    private static final String KEY_GET_SORT_BY = "KEY_GET_SORT_BY";

    private Context context;
    private SharedPreferences sharedPerfs;
    private SharedPreferences.Editor editor;

    static String perfsName = "UserHelper";
    static int perfsMode = 0;

    public SharedPerfsUtils(Context context) {
        this.context = context;
        this.sharedPerfs = this.context.getSharedPreferences(perfsName, perfsMode);
        this.editor = sharedPerfs.edit();
    }

    public void saveSortBy(int sortBy){
        editor.putInt(KEY_GET_SORT_BY, sortBy);
        editor.commit();
    }

    public int getSortBy(){
      return sharedPerfs.getInt(KEY_GET_SORT_BY , Constant.SORT_LOW_TO_HIGH);
    }
}

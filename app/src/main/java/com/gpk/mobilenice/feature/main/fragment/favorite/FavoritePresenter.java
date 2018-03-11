package com.gpk.mobilenice.feature.main.fragment.favorite;

import android.util.Log;

import com.gpk.mobilenice.db.DataBaseManager;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class FavoritePresenter implements FavoriteInterface.Presenter {

    private DataBaseManager dataBaseManager;
    private FavoriteInterface.View view;

    public FavoritePresenter(FavoriteInterface.View view) {
        this.view = view;
        dataBaseManager = new DataBaseManager();
    }

    @Override
    public void loadAllFavorite() {
        Log.d("DEV" , "dataBaseManager.getAllFavorite().size() : " + dataBaseManager.getAllFavorite().size());
        dataBaseManager.getAllFavorite().size();
    }
}

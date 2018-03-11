package com.gpk.mobilenice.feature.main.fragment.favorite;

import android.content.Context;
import android.util.Log;

import com.gpk.mobilenice.db.DataBaseManager;
import com.gpk.mobilenice.model.MobileModel;
import com.gpk.mobilenice.utils.SortCollection;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class FavoritePresenter implements FavoriteInterface.Presenter {

    private Context context;
    private DataBaseManager dataBaseManager;
    private FavoriteInterface.View view;
    private List<MobileModel> mobileList;

    public FavoritePresenter(Context context ,FavoriteInterface.View view) {
        this.context = context;
        this.view = view;
        dataBaseManager = DataBaseManager.newInstant();
    }

    @Override
    public void loadAllFavorite() {
        mobileList = dataBaseManager.getAllFavorite();
        sortData();
    }

    @Override
    public void sortData() {
        if (mobileList != null){
            SortCollection sortCollection = new SortCollection(context);
            sortCollection.sortData(mobileList);
            view.updateDataFavoriteAll(mobileList);
        }
    }

    @Override
    public void deleteFavorite(MobileModel mobileModel) {
        dataBaseManager.deleteFavorite(mobileModel);
    }
}

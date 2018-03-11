package com.gpk.mobilenice.feature.main.fragment.favorite;

import com.gpk.mobilenice.model.MobileModel;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public interface FavoriteInterface {
    interface View{
        void updateDataFavoriteAll(List<MobileModel> modelList);
    }

    interface Presenter{
        void loadAllFavorite();
    }
}

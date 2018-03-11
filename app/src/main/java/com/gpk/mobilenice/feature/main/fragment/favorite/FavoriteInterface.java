package com.gpk.mobilenice.feature.main.fragment.favorite;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public interface FavoriteInterface {
    interface View{
        void updateDataFavoriteAll();
    }

    interface Presenter{
        void loadAllFavorite();
    }
}

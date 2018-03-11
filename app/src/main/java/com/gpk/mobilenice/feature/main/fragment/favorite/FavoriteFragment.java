package com.gpk.mobilenice.feature.main.fragment.favorite;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseFragment;
import com.gpk.mobilenice.databinding.LayoutRecycleViewBinding;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class FavoriteFragment extends BaseFragment implements FavoriteInterface.View{

    private LayoutRecycleViewBinding binding;
    private FavoritePresenter favoritePresenter;

    public static FavoriteFragment newInstant() {
        FavoriteFragment fragment = new FavoriteFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.layout_recycle_view , container , false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initObj();
        initView();
    }

    private void initObj(){
        favoritePresenter = new FavoritePresenter(this);
    }

    private void initView(){
        favoritePresenter.loadAllFavorite();
    }

    @Override
    public void updateDataFavoriteAll() {

    }
}

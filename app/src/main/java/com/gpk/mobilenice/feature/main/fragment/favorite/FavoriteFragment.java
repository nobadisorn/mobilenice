package com.gpk.mobilenice.feature.main.fragment.favorite;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseFragment;
import com.gpk.mobilenice.bus.BusEvent;
import com.gpk.mobilenice.bus.event.RefreshOnSortEvent;
import com.gpk.mobilenice.common.Constant;
import com.gpk.mobilenice.databinding.LayoutRecycleViewBinding;
import com.gpk.mobilenice.feature.main.adapter.MobileListAdapter;
import com.gpk.mobilenice.model.MobileModel;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class FavoriteFragment extends BaseFragment implements FavoriteInterface.View {

    private LayoutRecycleViewBinding binding;
    private FavoritePresenter favoritePresenter;
    private MobileListAdapter mobileListAdapter;

    public static FavoriteFragment newInstant() {
        FavoriteFragment fragment = new FavoriteFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_recycle_view, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initObj();
        initView();
    }

    private void initObj() {
        favoritePresenter = new FavoritePresenter(getContext(), this);
        mobileListAdapter = new MobileListAdapter(Constant.VIEW_FOVORITE_LIST);
    }

    private void initView() {
        BusEvent.newInstant().register(this);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycleView.setAdapter(mobileListAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(binding.recycleView);
    }

    private ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int position = viewHolder.getAdapterPosition();
                    favoritePresenter.deleteFavorite(mobileListAdapter.getMobileModelByPosition(position));
                }
            });
        }
    };

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) favoritePresenter.loadAllFavorite();
    }

    @Override
    public void updateDataFavoriteAll(final List<MobileModel> modelList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mobileListAdapter.setMobileList(modelList);
            }
        });
    }

    @Subscribe
    public void refreshView(RefreshOnSortEvent event) {
        favoritePresenter.sortData();
    }
}

package com.gpk.mobilenice.feature.main.fragment.mobilelist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
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
import com.gpk.mobilenice.utils.SortCollection;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class MobileListFragment extends BaseFragment implements MobileListInterface.View{

    private LayoutRecycleViewBinding binding;
    private MobileListAdapter mobileListAdapter;
    private MobileListPresenter mobileListPresenter;

    public static MobileListFragment newInstant() {
        MobileListFragment fragment = new MobileListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.layout_recycle_view, container , false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initObj();
        initView();
    }

    private void initObj(){
        mobileListPresenter = new MobileListPresenter(getContext() ,this);
        mobileListAdapter = new MobileListAdapter(Constant.VIEW_MOBILE_LIST);
    }

    private void initView(){
        BusEvent.newInstant().register(this);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycleView.setAdapter(mobileListAdapter);
        mobileListPresenter.getMobileList();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            if (mobileListAdapter != null) {
                mobileListPresenter.sortData();
            }
        }
    }

    @Override
    public void updateMobileListData(final List<MobileModel> mobileList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SortCollection sortCollection = new SortCollection(getContext());
                sortCollection.sortData(mobileList);
                mobileListAdapter.setMobileList(mobileList);
            }
        });
    }

    @Subscribe
    public void refreshView(RefreshOnSortEvent event){
        mobileListPresenter.sortData();
    }

}

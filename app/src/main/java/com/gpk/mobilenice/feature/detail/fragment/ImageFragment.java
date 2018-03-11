package com.gpk.mobilenice.feature.detail.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseFragment;
import com.gpk.mobilenice.databinding.LayoutImageViewBinding;
import com.gpk.mobilenice.model.MobileDetailModel;
import com.gpk.mobilenice.utils.ImageCache;

import org.parceler.Parcels;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class ImageFragment extends BaseFragment {
    private static final String KET_GET_DETAIL_DATA = "KET_GET_DETAIL_DATA";

    private LayoutImageViewBinding binding;
    private MobileDetailModel detailModel;

    public static ImageFragment newInstant(MobileDetailModel detailModel) {
        ImageFragment fragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KET_GET_DETAIL_DATA , Parcels.wrap(detailModel));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.layout_image_view, container , false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initObj();
        initView();
    }
    private void initObj(){
        detailModel = Parcels.unwrap(getArguments().getParcelable(KET_GET_DETAIL_DATA));
    }
    private void initView(){
        ImageCache.load(getContext() , detailModel.getUrl() , binding.imgThumb);
    }
}

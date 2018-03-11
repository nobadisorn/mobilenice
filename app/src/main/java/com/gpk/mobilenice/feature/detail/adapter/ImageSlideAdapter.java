package com.gpk.mobilenice.feature.detail.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gpk.mobilenice.feature.detail.fragment.ImageFragment;
import com.gpk.mobilenice.model.MobileDetailModel;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class ImageSlideAdapter extends FragmentPagerAdapter {
    private List<MobileDetailModel> mobileDetailModels;

    public ImageSlideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstant(mobileDetailModels.get(position));
    }

    @Override
    public int getCount() {
        return (mobileDetailModels != null) ? mobileDetailModels.size() : 0;
    }

    public void setMobileDetailModels(List<MobileDetailModel> mobileDetailModels) {
        this.mobileDetailModels = mobileDetailModels;
        notifyDataSetChanged();
    }
}

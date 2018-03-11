package com.gpk.mobilenice.feature.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.feature.main.fragment.favorite.FavoriteFragment;
import com.gpk.mobilenice.feature.main.fragment.mobilelist.MobileListFragment;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private String title[];

    public PageAdapter(FragmentManager fm , Context context) {
        super(fm);
        title = context.getResources().getStringArray(R.array.tabTitle);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return MobileListFragment.newInstant();
        else
            return FavoriteFragment.newInstant();
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}

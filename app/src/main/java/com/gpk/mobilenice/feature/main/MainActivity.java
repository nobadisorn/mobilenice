package com.gpk.mobilenice.feature.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseActivity;
import com.gpk.mobilenice.databinding.ActivityMainBinding;
import com.gpk.mobilenice.feature.main.adapter.PageAdapter;

public class MainActivity extends BaseActivity implements MainInterface.View{

    private ActivityMainBinding binding;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        initObj();
        initView();
    }

    private void initObj(){
        pageAdapter = new PageAdapter(getSupportFragmentManager() , this);
    }

    private void initView(){
        binding.viewPage.setAdapter(pageAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPage);
    }

    @Override
    public void updateDataMobileList() {

    }
}

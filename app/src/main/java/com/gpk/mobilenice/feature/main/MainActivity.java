package com.gpk.mobilenice.feature.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseActivity;
import com.gpk.mobilenice.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity implements MainInterface.View{

    private ActivityMainBinding binding;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        initObj();
    }

    private void initObj(){
        layoutManager = new LinearLayoutManager(this);
    }

    @Override
    public void updateDataMobileList() {

    }
}

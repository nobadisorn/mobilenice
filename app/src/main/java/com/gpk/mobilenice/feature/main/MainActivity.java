package com.gpk.mobilenice.feature.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseActivity;
import com.gpk.mobilenice.databinding.ActivityMainBinding;
import com.gpk.mobilenice.feature.main.adapter.PageAdapter;
import com.gpk.mobilenice.feature.main.dialog.SortDialog;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainInterface.View {

    private ActivityMainBinding binding;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initObj();
        initView();
    }

    private void initObj() {
        pageAdapter = new PageAdapter(getSupportFragmentManager(), this);
    }

    private void initView() {
        setSupportActionBar(binding.toolbar);
        binding.viewPage.setAdapter(pageAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            showSortDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSortDialog(){
        SortDialog sortDialog = SortDialog.newInstant();
        sortDialog.show(getSupportFragmentManager() , getClass().getSimpleName());
    }

    @Override
    public void updateDataMobileList() {

    }
}

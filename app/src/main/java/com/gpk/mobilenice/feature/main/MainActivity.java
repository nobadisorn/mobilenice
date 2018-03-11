package com.gpk.mobilenice.feature.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseActivity;
import com.gpk.mobilenice.bus.BusEvent;
import com.gpk.mobilenice.bus.event.RefreshOnSortEvent;
import com.gpk.mobilenice.databinding.ActivityMainBinding;
import com.gpk.mobilenice.feature.main.adapter.PageAdapter;
import com.gpk.mobilenice.feature.main.dialog.SortDialog;


public class MainActivity extends BaseActivity implements MainInterface.View {

    private ActivityMainBinding binding;
    private PageAdapter pageAdapter;
    private SortDialog sortDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initObj();
        initView();
        initListener();
    }

    private void initObj() {
        pageAdapter = new PageAdapter(getSupportFragmentManager(), this);
        sortDialog = SortDialog.newInstant();
    }

    private void initView() {
        BusEvent.newInstant().register(this);
        setSupportActionBar(binding.toolbar);
        binding.viewPage.setAdapter(pageAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPage);
    }

    private void initListener(){
        sortDialog.setSortDialogListener(new SortDialog.SortDialogListener() {
            @Override
            public void onClickChange() {
                BusEvent.newInstant().post(new RefreshOnSortEvent());
            }
        });
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
        sortDialog.show(getSupportFragmentManager() , getClass().getSimpleName());
    }


}

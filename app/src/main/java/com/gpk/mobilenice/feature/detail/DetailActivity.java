package com.gpk.mobilenice.feature.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.MenuItem;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.base.BaseActivity;
import com.gpk.mobilenice.databinding.ActivityDetailBinding;
import com.gpk.mobilenice.feature.detail.adapter.ImageSlideAdapter;
import com.gpk.mobilenice.model.MobileDetailModel;
import com.gpk.mobilenice.model.MobileModel;

import org.parceler.Parcels;

import java.util.List;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class DetailActivity extends BaseActivity implements DetailInterface.View{
    private static final String KET_GET_MOBILE_MODEL = "KET_GET_MOBILE_MODEL";

    private ActivityDetailBinding binding;
    private ImageSlideAdapter imageSlideAdapter;
    private DetailPresenter detailPresenter;
    private MobileModel mobileModel;

    public static void newIntent(Context context , MobileModel mobileModel){
        Intent intent = new Intent(context , DetailActivity.class);
        intent.putExtra(KET_GET_MOBILE_MODEL , Parcels.wrap(mobileModel));
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_detail);

        initObj();
        initView();
    }

    private void initObj(){
        mobileModel = Parcels.unwrap(getIntent().getParcelableExtra(KET_GET_MOBILE_MODEL));
        detailPresenter = new DetailPresenter(this);
        imageSlideAdapter = new ImageSlideAdapter(getSupportFragmentManager());
    }

    private void initView(){
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        binding.viewPage.setAdapter(imageSlideAdapter);
        detailPresenter.loadDetailData(mobileModel.getId());
        binding.tvPrice.setText(String.format(getResources().getString(R.string.price) , mobileModel.getPrice()));
        binding.tvRating.setText(String.format(getResources().getString(R.string.rating) , mobileModel.getRating()));
        String title = "<b>" + mobileModel.getBrand() + "</b> " + mobileModel.getBrand();
        binding.tvTitle.setText(Html.fromHtml(title));
        binding.tvDetail.setText(mobileModel.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateDetailData(final List<MobileDetailModel> mobileDetailModels) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageSlideAdapter.setMobileDetailModels(mobileDetailModels);

            }
        });
    }
}

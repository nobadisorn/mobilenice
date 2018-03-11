package com.gpk.mobilenice.feature.main.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.common.Constant;
import com.gpk.mobilenice.databinding.ItemMobileListBinding;
import com.gpk.mobilenice.db.DataBaseManager;
import com.gpk.mobilenice.feature.detail.DetailActivity;
import com.gpk.mobilenice.model.MobileModel;
import com.gpk.mobilenice.utils.ImageCache;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    private ItemMobileListBinding binding;
    private MobileModel mobileModel;
    private DataBaseManager dataBaseManager;
    private Context context;

    public ListViewHolder(ItemMobileListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        this.context = binding.getRoot().getContext();
        initObj();
    }

    private void initObj(){
        dataBaseManager = DataBaseManager.newInstant();
    }

    public void bind(MobileModel mobileModel , int viewType){
        binding.executePendingBindings();
        this.mobileModel = mobileModel;
        binding.cbFavorite.setOnCheckedChangeListener(null);
        ImageCache.load(binding.getRoot().getContext() , mobileModel.getThumbImageURL() , binding.imgThumb);
        binding.tvTitle.setText(mobileModel.getName());
        binding.tvDetail.setText(mobileModel.getDescription());
        binding.tvPrice.setText(String.format(context.getResources().getString(R.string.price) , mobileModel.getPrice()));
        binding.tvRating.setText(String.format(context.getResources().getString(R.string.rating) , mobileModel.getRating()));
        if (viewType == Constant.VIEW_MOBILE_LIST) {
            binding.cbFavorite.setChecked(dataBaseManager.checkIsFavorite(mobileModel));
            binding.cbFavorite.setVisibility(View.VISIBLE);
        }
        else {
            binding.cbFavorite.setVisibility(View.GONE);
        }

        initListener();
    }

    private void initListener(){
        binding.cbFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if (isCheck) saveFavorite();
                else deleteFavorite();
            }
        });

        binding.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity.newIntent(context , mobileModel);
            }
        });
    }

    private void saveFavorite(){
        dataBaseManager.saveFavorite(mobileModel);
    }

    private void deleteFavorite(){
        dataBaseManager.deleteFavorite(mobileModel);
    }
}

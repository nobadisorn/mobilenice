package com.gpk.mobilenice.feature.main.adapter.viewholder;

import android.support.v7.widget.RecyclerView;

import com.gpk.mobilenice.databinding.ItemMobileListBinding;
import com.gpk.mobilenice.model.MobileModel;
import com.gpk.mobilenice.utils.ImageCache;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    private ItemMobileListBinding binding;

    public ListViewHolder(ItemMobileListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(MobileModel mobileModel){
        ImageCache.load(binding.getRoot().getContext() , mobileModel.getThumbImageURL() , binding.imgThumb);
        binding.tvTitle.setText(mobileModel.getName());
        binding.tvDetail.setText(mobileModel.getDescription());
    }
}

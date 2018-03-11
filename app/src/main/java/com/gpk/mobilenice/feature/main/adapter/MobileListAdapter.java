package com.gpk.mobilenice.feature.main.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.databinding.ItemMobileListBinding;
import com.gpk.mobilenice.feature.main.adapter.viewholder.ListViewHolder;
import com.gpk.mobilenice.model.MobileModel;

import java.util.List;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class MobileListAdapter extends RecyclerView.Adapter {

    private List<MobileModel> mobileList;
    private int viewType;

    public MobileListAdapter(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMobileListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_mobile_list, parent, false);
        return new ListViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListViewHolder viewHolder = (ListViewHolder) holder;
        viewHolder.bind(mobileList.get(position), viewType);
    }

    @Override
    public int getItemCount() {
        return (mobileList != null) ? mobileList.size() : 0;
    }

    public void setMobileList(List<MobileModel> mobileList) {
        this.mobileList = mobileList;
        notifyDataSetChanged();
    }

    public MobileModel getMobileModelByPosition(int position) {
        return mobileList.get(position);
    }
}

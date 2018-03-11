package com.gpk.mobilenice.feature.main.dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gpk.mobilenice.R;
import com.gpk.mobilenice.common.Constant;
import com.gpk.mobilenice.databinding.DialogSortBinding;
import com.gpk.mobilenice.utils.SharedPerfsUtils;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class SortDialog extends DialogFragment {

    private DialogSortBinding binding;
    private SharedPerfsUtils perfsUtils;

    public static SortDialog newInstant() {
        SortDialog sortDialog = new SortDialog();
        return sortDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater , R.layout.dialog_sort , container , false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initObj();
        initView();
        initListener();
    }

    private void initObj(){
        perfsUtils = new SharedPerfsUtils(getContext());
    }

    private void initView(){
        Window window = getDialog().getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        ((RadioButton)binding.rbGroup.getChildAt(perfsUtils.getSortBy())).setChecked(true);
    }

    private void initListener(){
        binding.rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                if (checkId == R.id.rb_low_to_high) perfsUtils.saveSortBy(Constant.SORT_LOW_TO_HIGH);
                else if (checkId == R.id.rb_high_to_low) perfsUtils.saveSortBy(Constant.SORT_HIGH_TO_LOW);
                else if (checkId == R.id.rb_rating) perfsUtils.saveSortBy(Constant.SORT_RATING);
                dismiss();
            }
        });
    }
}

package com.gpk.mobilenice.view;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.gpk.mobilenice.R;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class FavoriteIconView extends AppCompatCheckBox {
    public FavoriteIconView(Context context) {
        super(context);
    }

    public FavoriteIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FavoriteIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setButtonDrawable(R.drawable.favorite_drawable);
    }
}

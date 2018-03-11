package com.gpk.mobilenice.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class ImageCache {

    public static void load(Context context, String urlImage, ImageView imageView) {
        Glide.with(context)
                .load(urlImage)
                .into(imageView);
    }
}

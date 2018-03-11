package com.gpk.mobilenice;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class MobileNiceApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("mobilenice.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}

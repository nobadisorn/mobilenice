package com.gpk.mobilenice.db;

import android.util.Log;

import com.gpk.mobilenice.model.MobileModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class DataBaseManager {
    private static DataBaseManager dataBaseManager;
    private Realm realm = Realm.getDefaultInstance();

    public static DataBaseManager newInstant() {
        if (dataBaseManager == null) {
            dataBaseManager = new DataBaseManager();
        }
        return dataBaseManager;
    }

    public DataBaseManager() {
        realm = Realm.getDefaultInstance();
    }

    public void saveFavorite(final MobileModel mobileModel) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealm(mobileModel);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("DEV", "save onSuccess");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.d("DEV", "save onError " + error.getMessage());
            }
        });
    }

    public List<MobileModel> getAllFavorite() {
        RealmResults<MobileModel> result = realm.where(MobileModel.class).findAll();
        List<MobileModel> results = new ArrayList<>(result);
        return results;
    }

    public void deleteFavorite(final MobileModel mobileModel) {
        final RealmResults<MobileModel> results = realm.where(MobileModel.class)
                .equalTo("id", mobileModel.getId())
                .findAll();

        if (results.isValid() && !results.isEmpty()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    results.deleteAllFromRealm();
                }
            });
        }
    }

    public boolean checkIsFavorite(final MobileModel mobileModel) {
        final RealmResults<MobileModel> results = realm.where(MobileModel.class)
                .equalTo("id", mobileModel.getId())
                .findAll();

        return results.size() > 0;
    }
}

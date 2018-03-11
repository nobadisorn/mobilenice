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
    Realm realm = Realm.getDefaultInstance();

    public void saveFavorite(final MobileModel mobileModel){
        realm.beginTransaction();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealm(mobileModel);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.d("DEV" , "save onSuccess");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.d("DEV" , "save onError " + error.getMessage());
            }
        });

        realm.commitTransaction();
    }

    public List<MobileModel> getAllFavorite() {
        RealmResults<MobileModel> result = realm.where(MobileModel.class).findAll();
        List<MobileModel> dd = new ArrayList<>(result);
        return result;
    }

    public void deleteFavorite(final MobileModel mobileModel){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                final RealmResults<MobileModel> results = realm.where(MobileModel.class)
                        .equalTo("id", mobileModel.getId())
                        .findAll();
                Log.d("DEV" , "results : " + results.size());
                results.deleteAllFromRealm();

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("DEV" , "delete onSuccess");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.d("DEV" , "delete onError " + error.getMessage());
            }
        });
    }

    public boolean checkisFavorite(final MobileModel mobileModel){
        final RealmResults<MobileModel> results = realm.where(MobileModel.class)
                .equalTo("id", mobileModel.getId())
                .findAll();

        return results.size() > 0;
    }
}

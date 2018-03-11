package com.gpk.mobilenice.feature.main.fragment.mobilelist;

import android.content.Context;

import com.gpk.mobilenice.httprequest.MobileAPIControler;
import com.gpk.mobilenice.model.MobileModel;
import com.gpk.mobilenice.utils.SortCollection;

import java.util.List;

/**
 * Created by nobtingtong on 10/3/2018 AD.
 */

public class MobileListPresenter implements MobileListInterface.Presenter {

    private Context context;
    private MobileAPIControler apiControler;
    private MobileListInterface.View view;
    private List<MobileModel> mobileList;

    public MobileListPresenter(Context context, MobileListInterface.View view) {
        apiControler = new MobileAPIControler();
        this.context = context;
        this.view = view;
    }

    @Override
    public void getMobileList() {
        apiControler.getMobileList(new MobileAPIControler.OnGetMobileListener() {
            @Override
            public void onSuccess(List<MobileModel> mobileLists) {
                mobileList = mobileLists;
                sortData();
            }

            @Override
            public void onFailure() {

            }
        });
    }


    @Override
    public void sortData() {
        if (mobileList != null) {
            SortCollection sortCollection = new SortCollection(context);
            sortCollection.sortData(mobileList);
            view.updateMobileListData(mobileList);
        }
    }
}

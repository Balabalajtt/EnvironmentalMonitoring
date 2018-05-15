package com.ute.environmentalmonitoring.work.presenter;

import android.util.Log;

import com.ute.environmentalmonitoring.base.presenter.BasePresenter;
import com.ute.environmentalmonitoring.base.rx.BaseSubscriber;
import com.ute.environmentalmonitoring.work.data.gson.First;
import com.ute.environmentalmonitoring.work.presenter.view.FirstView;
import com.ute.environmentalmonitoring.work.service.impl.FirstServiceImpl;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/14.
 */

public class FirstPresenter extends BasePresenter<FirstView> {
    private static final String TAG = "FirstPresenter";

    public void getFirstData(String location) {
        Log.d(TAG, "getFirstData: " + location);
        mView.onRefresh();
        new FirstServiceImpl().getFirstData(location)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<First>() {
                    @Override
                    public void onNext(First first) {
                        super.onNext(first);
//                        Log.d(TAG, "onNext: " + first.getData().toString());
                        if (first.getStatus() == 1) {
                            mView.onGetDataSucc(first.getData());
                        } else {
                            mView.onGetDataFail();
                        }

                    }
                });
    }

}

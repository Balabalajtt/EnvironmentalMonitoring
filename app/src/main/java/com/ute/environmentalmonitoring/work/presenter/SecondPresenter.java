package com.ute.environmentalmonitoring.work.presenter;

import android.util.Log;

import com.ute.environmentalmonitoring.base.presenter.BasePresenter;
import com.ute.environmentalmonitoring.base.rx.BaseSubscriber;
import com.ute.environmentalmonitoring.work.data.gson.Second;
import com.ute.environmentalmonitoring.work.presenter.view.SecondView;
import com.ute.environmentalmonitoring.work.service.impl.SecondServiceImpl;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class SecondPresenter extends BasePresenter<SecondView> {

    private static final String TAG = "SecondPresenter";

    public void getSecondData(String position, int type, String target) {
        mView.onRefresh();
        new SecondServiceImpl().getSecondData(position, type, target)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Second>() {
                    @Override
                    public void onNext(Second second) {
                        super.onNext(second);
                        if (second.getStatus() == 1) {
                            mView.onGetDataSucc(second.getData());
                        } else {
                            mView.onGetDataFail();
                        }

                    }
                });
    }

}

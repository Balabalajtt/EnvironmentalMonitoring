package com.ute.environmentalmonitoring.work.service.impl;

import com.ute.environmentalmonitoring.base.net.RetrofitFactory;
import com.ute.environmentalmonitoring.work.data.api.MainApi;
import com.ute.environmentalmonitoring.work.data.gson.Second;
import com.ute.environmentalmonitoring.work.service.SecondService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class SecondServiceImpl implements SecondService {
    @Override
    public Observable<Second> getSecondData(String position, int type, String target) {
        return RetrofitFactory.INSTANCE.create(MainApi.class)
                .getSecondData(position, type, target);
    }
}

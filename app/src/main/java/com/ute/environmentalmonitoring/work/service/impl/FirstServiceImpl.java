package com.ute.environmentalmonitoring.work.service.impl;

import com.ute.environmentalmonitoring.base.net.RetrofitFactory;
import com.ute.environmentalmonitoring.work.data.api.LoginApi;
import com.ute.environmentalmonitoring.work.data.api.MainApi;
import com.ute.environmentalmonitoring.work.data.gson.First;
import com.ute.environmentalmonitoring.work.service.FirstService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class FirstServiceImpl implements FirstService {
    @Override
    public Observable<First> getFirstData(String location) {
        return RetrofitFactory.INSTANCE.create(MainApi.class)
                .getFirstData(location);
    }
}

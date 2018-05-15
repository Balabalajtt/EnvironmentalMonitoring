package com.ute.environmentalmonitoring.work.service.impl;

import com.ute.environmentalmonitoring.base.net.RetrofitFactory;
import com.ute.environmentalmonitoring.work.data.api.LoginApi;
import com.ute.environmentalmonitoring.work.service.LoginService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class LoginServiceImpl implements LoginService {
    @Override
    public Observable<ResponseBody> login(String phone, String pwd) {
        return RetrofitFactory.INSTANCE.create(LoginApi.class)
                .login(phone, pwd);
    }

    @Override
    public Observable<ResponseBody> register(int type, String code, String name, String phone, String pwd) {
        return RetrofitFactory.INSTANCE.create(LoginApi.class)
                .register(type, code, name, phone, pwd);
    }
}

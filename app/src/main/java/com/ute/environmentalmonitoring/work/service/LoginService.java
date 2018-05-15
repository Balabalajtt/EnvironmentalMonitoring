package com.ute.environmentalmonitoring.work.service;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface LoginService {
    Observable<ResponseBody> login(String phone, String pwd);
    Observable<ResponseBody> register(int type, String code, String name, String phone, String pwd);
}

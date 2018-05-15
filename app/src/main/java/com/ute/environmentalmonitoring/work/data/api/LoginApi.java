package com.ute.environmentalmonitoring.work.data.api;

import com.ute.environmentalmonitoring.base.common.Constant;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface LoginApi {
    @POST(Constant.LOGIN)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> login(@Field("phone") String phone, @Field("password") String pwd);

    @POST(Constant.REGISTER)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> register(@Field("xh") int type, @Field("xh") String code, @Field("xh") String name, @Field("xh") String phone, @Field("xh") String pwd);

}

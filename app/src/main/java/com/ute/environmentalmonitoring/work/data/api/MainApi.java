package com.ute.environmentalmonitoring.work.data.api;

import com.ute.environmentalmonitoring.base.common.Constant;
import com.ute.environmentalmonitoring.work.data.gson.First;
import com.ute.environmentalmonitoring.work.data.gson.Second;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface MainApi {
    @POST(Constant.FIRSTDATA)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<First> getFirstData(@Field("position") String location);

    @POST(Constant.SECONDDATA)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<Second> getSecondData(@Field("position") String position, @Field("type") int type, @Field("target") String target);
}

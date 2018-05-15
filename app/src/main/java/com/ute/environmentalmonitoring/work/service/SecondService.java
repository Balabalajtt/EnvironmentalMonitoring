package com.ute.environmentalmonitoring.work.service;

import com.ute.environmentalmonitoring.work.data.gson.First;
import com.ute.environmentalmonitoring.work.data.gson.Second;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface SecondService {
    Observable<Second> getSecondData(String position, int type, String target);
}

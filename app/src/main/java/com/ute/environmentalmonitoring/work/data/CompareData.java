package com.ute.environmentalmonitoring.work.data;

/**
 * Created by 江婷婷 on 2018/5/13.
 */

public class CompareData {
    public String time;
    public int localData;
    public int nationData;

    public CompareData(String time, int localData, int nationData) {
        this.time = time;
        this.localData = localData;
        this.nationData = nationData;
    }
}

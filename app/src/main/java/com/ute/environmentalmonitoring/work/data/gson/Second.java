package com.ute.environmentalmonitoring.work.data.gson;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/16.
 */

public class Second {
    private int status;
    private String msg;
    private List<SecondData> data;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setData(List<SecondData> data) {
        this.data = data;
    }
    public List<SecondData> getData() {
        return data;
    }
}

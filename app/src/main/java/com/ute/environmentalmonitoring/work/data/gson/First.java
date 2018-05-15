package com.ute.environmentalmonitoring.work.data.gson;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class First {
    private int status;
    private String msg;
    private FirstData data;
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

    public void setData(FirstData data) {
        this.data = data;
    }
    public FirstData getData() {
        return data;
    }
}

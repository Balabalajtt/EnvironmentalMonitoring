package com.ute.environmentalmonitoring.work.data.gson;

import java.util.Date;

/**
 * Created by 江婷婷 on 2018/5/16.
 */

public class SecondData {
    private double nationalTarget;
    private double positionTarget;
    private String timestamp;

    public double getNationalTarget() {
        return nationalTarget;
    }

    public void setNationalTarget(double nationalTarget) {
        this.nationalTarget = nationalTarget;
    }

    public double getPositionTarget() {
        return positionTarget;
    }

    public void setPositionTarget(double positionTarget) {
        this.positionTarget = positionTarget;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

package com.ute.environmentalmonitoring.work.data.gson;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class FirstData {
    private int id;
    private long timestamp;
    private double temperature;
    private double humidity;
    private double pm25;
    private double pm10;
    private double so2;
    private double no2;
    private double o3;
    private double co;
    private double aqi;
    private String status;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public double getHumidity() {
        return humidity;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }
    public double getPm25() {
        return pm25;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }
    public double getPm10() {
        return pm10;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }
    public double getSo2() {
        return so2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }
    public double getNo2() {
        return no2;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }
    public double getO3() {
        return o3;
    }

    public void setCo(double co) {
        this.co = co;
    }
    public double getCo() {
        return co;
    }

    public void setAqi(double aqi) {
        this.aqi = aqi;
    }
    public double getAqi() {
        return aqi;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return aqi + " " + status;
    }
}

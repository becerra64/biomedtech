package com.example.biomedtech.dexcomAPI;

import java.time.OffsetDateTime;

public class Egv {

    public Egv() {
    }

    public Egv(String systemTime, String displayTime, long value, long realtimeValue, long smoothedValue, String status, String trend, double trendRate) {
        this.systemTime = systemTime;
        this.displayTime = displayTime;
        this.value = value;
        this.realtimeValue = realtimeValue;
        this.smoothedValue = smoothedValue;
        this.status = status;
        this.trend = trend;
        this.trendRate = trendRate;
    }

    private String systemTime;
    private String displayTime;
    private long value;
    private long realtimeValue;
    private long smoothedValue;
    private String status;
    private String trend;
    private double trendRate;

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String value) {
        this.systemTime = value;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String value) {
        this.displayTime = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getRealtimeValue() {
        return realtimeValue;
    }

    public void setRealtimeValue(long value) {
        this.realtimeValue = value;
    }

    public long getSmoothedValue() {
        return smoothedValue;
    }

    public void setSmoothedValue(long value) {
        this.smoothedValue = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String value) {
        this.trend = value;
    }

    public double getTrendRate() {
        return trendRate;
    }

    public void setTrendRate(double value) {
        this.trendRate = value;
    }
}

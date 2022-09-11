package com.example.biomedtech.dexcomAPI;

import java.time.OffsetDateTime;

public class Egv {
    private OffsetDateTime systemTime;
    private OffsetDateTime displayTime;
    private long value;
    private long realtimeValue;
    private long smoothedValue;
    private Object status;
    private Trend trend;
    private double trendRate;

    public OffsetDateTime getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(OffsetDateTime value) {
        this.systemTime = value;
    }

    public OffsetDateTime getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(OffsetDateTime value) {
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

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object value) {
        this.status = value;
    }

    public Trend getTrend() {
        return trend;
    }

    public void setTrend(Trend value) {
        this.trend = value;
    }

    public double getTrendRate() {
        return trendRate;
    }

    public void setTrendRate(double value) {
        this.trendRate = value;
    }
}

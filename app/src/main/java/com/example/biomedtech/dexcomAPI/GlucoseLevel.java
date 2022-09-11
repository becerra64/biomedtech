package com.example.biomedtech.dexcomAPI;

import java.io.IOException;
import java.time.OffsetDateTime;

public class GlucoseLevel {
    private String unit;
    private String rateUnit;
    private Egv[] egvs;

    public String getUnit() { return unit; }
    public void setUnit(String value) { this.unit = value; }

    public String getRateUnit() { return rateUnit; }
    public void setRateUnit(String value) { this.rateUnit = value; }

    public Egv[] getEgvs() { return egvs; }
    public void setEgvs(Egv[] value) { this.egvs = value; }
}


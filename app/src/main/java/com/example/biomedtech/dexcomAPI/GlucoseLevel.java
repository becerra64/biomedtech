package com.example.biomedtech.dexcomAPI;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class GlucoseLevel {

    public GlucoseLevel() {
    }

    public GlucoseLevel(String unit, String rateUnit, ArrayList<Egv> egvs) {
        this.unit = unit;
        this.rateUnit = rateUnit;
        this.egvs = egvs;
    }

    private String unit;
    private String rateUnit;
    private ArrayList<Egv> egvs;

    public String getUnit() { return unit; }
    public void setUnit(String value) { this.unit = value; }

    public String getRateUnit() { return rateUnit; }
    public void setRateUnit(String value) { this.rateUnit = value; }

    public ArrayList<Egv> getEgvs() { return egvs; }
    public void setEgvs(ArrayList<Egv> value) { this.egvs = value; }
}


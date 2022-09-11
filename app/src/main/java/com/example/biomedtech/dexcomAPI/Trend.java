package com.example.biomedtech.dexcomAPI;

import java.io.IOException;

public enum Trend {
    FLAT, FORTY_FIVE_DOWN;

    public String toValue() {
        switch (this) {
            case FLAT:
                return "flat";
            case FORTY_FIVE_DOWN:
                return "fortyFiveDown";
        }
        return null;
    }

    public static Trend forValue(String value) throws IOException {
        if (value.equals("flat")) return FLAT;
        if (value.equals("fortyFiveDown")) return FORTY_FIVE_DOWN;
        throw new IOException("Cannot deserialize Trend");
    }
}

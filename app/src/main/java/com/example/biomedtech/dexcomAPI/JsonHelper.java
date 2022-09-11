package com.example.biomedtech.dexcomAPI;

import flexjson.JSONDeserializer;

public class JsonHelper {

    public DexconAuthStructure accessTokenStr(String jsonString)
    {
        JSONDeserializer<DexconAuthStructure> deserializer = new JSONDeserializer<DexconAuthStructure>();
        DexconAuthStructure resval = deserializer.deserialize(jsonString);
        return resval;
    }

    public GlucoseLevel glucoseMeasure(String egvsStr) {
        JSONDeserializer<GlucoseLevel> deserializer =  new JSONDeserializer<GlucoseLevel>();
        GlucoseLevel resval = deserializer.deserialize(egvsStr);
        return resval;
    }
}

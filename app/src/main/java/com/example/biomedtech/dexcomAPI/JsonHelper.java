package com.example.biomedtech.dexcomAPI;

//import flexjson.JSONDeserializer;
import com.google.gson.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class JsonHelper {

    public DexconAuthStructure accessTokenStr(String jsonString)
    {
        DexconAuthStructure auth = new DexconAuthStructure();
        try{
            JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
            auth = new DexconAuthStructure();
            auth.setAccessToken(jsonObject.get("access_token").getAsString());
            auth.setExpiresIn(jsonObject.get("expires_in").getAsLong());
            auth.setTokenType(jsonObject.get("token_type").getAsString());
            auth.setRefreshToken(jsonObject.get("refresh_token").getAsString());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return auth;
    }

    public GlucoseLevel glucoseMeasure(String egvsStr) {
        GlucoseLevel level = new GlucoseLevel();
        JsonObject jsonObject = new Gson().fromJson(egvsStr, JsonObject.class);
        level.setUnit(jsonObject.get("unit").getAsString());
        level.setRateUnit(jsonObject.get("rateUnit").getAsString());
        JsonArray jsonArray = jsonObject.get("egvs").getAsJsonArray();
        ArrayList<Egv> measures = new ArrayList<>();
        for(JsonElement item : jsonArray)
        {
            JsonObject evgJson = item.getAsJsonObject();
            Egv measure = new Egv();
            measure.setSystemTime(evgJson.get("systemTime").getAsString());
            measure.setDisplayTime(evgJson.get("displayTime").getAsString());
            measure.setValue(evgJson.get("value").getAsLong());
            measure.setRealtimeValue(evgJson.get("realtimeValue").getAsLong());
            measure.setSmoothedValue(evgJson.get("smoothedValue").getAsLong());
            String status = evgJson.get("status").isJsonNull()? "" : evgJson.get("status").getAsString();
            measure.setStatus(status);
            measure.setTrend(evgJson.get("trend").getAsString());
            measure.setTrendRate(evgJson.get("trendRate").getAsDouble());
            measures.add(measure);
        }
        level.setEgvs(measures);
        return level;
    }
}

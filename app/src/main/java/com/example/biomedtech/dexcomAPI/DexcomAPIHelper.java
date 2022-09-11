package com.example.biomedtech.dexcomAPI;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DexcomAPIHelper {
    private DexcomAPIHelper(){}
    private static volatile DexcomAPIHelper instance;
    public static DexcomAPIHelper getInstance()
    {
        DexcomAPIHelper result= instance;
        if(result != null)
        {
            return result;
        }
        synchronized (DexcomAPIHelper.class)
        {
            if(instance == null)
            {
                instance = new DexcomAPIHelper();
            }
            return instance;
        }
    }

    public String tokenCreator()
    {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create("client_secret=bY1LxzmzaRSlx0AA&client_id=fZMYMN1ddk4PJDfSAK8S3QUYvTXeIQas&code=ae2d9c3cd219230c1bbba71316b3ff5c&grant_type=authorization_code&redirect_uri=dexcomg6://uam_redirect_uri",mediaType);
        Request request = new Request.Builder()
                .url("https://sandbox-api.dexcom.com/v2/oauth2/token")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String egvRequest(String token){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox-api.dexcom.com/v2/users/self/egvs?startDate=2017-06-16T15:30:00&endDate=2017-06-16T15:45:00")
                .get()
                .addHeader("authorization", "Bearer" + token)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public GlucoseLevel getGlucoseMeasure()
    {
        JsonHelper jsonHelper = new JsonHelper();

        String apiResponse = tokenCreator();
        DexconAuthStructure authStructure = jsonHelper.accessTokenStr(apiResponse);
        String accessTokenStr = authStructure.getAccessToken();
        String egvsStr = egvRequest(accessTokenStr);
        GlucoseLevel glucoseMeasure = jsonHelper.glucoseMeasure(egvsStr);
        return glucoseMeasure;
    }
}
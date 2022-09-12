package com.example.biomedtech.dexcomAPI;
import java.util.Random;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.telephony.SmsManager;
import java.io.IOException;
import java.sql.Time;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatterBuilder;

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
        Random ran = new Random();
        int rand = ran.nextInt(6);
        String hourstr = "10";
        switch (rand)
        {
            case 0:
                hourstr = "13";
                break;
            case 1:
                hourstr = "12";
                break;
            case 2:
                hourstr = "14";
                break;
            case 3:
                hourstr = "15";
                break;
            case 4:
                hourstr = "16";
                break;
            case 5:
                hourstr = "17";
                break;
            case 6:
                hourstr = "18";
                break;
            case 7:
                hourstr = "19";
                break;
        }
        Request request = new Request.Builder()
                .url("https://sandbox-api.dexcom.com/v2/users/self/egvs?startDate=2022-06-16T" + hourstr +":30:00&endDate=2022-06-16T"+ hourstr +":45:00")
                .get()
                .addHeader("authorization", "Bearer " + token)
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

    //Danger: Hardcoded part
//    protected void sendSMSMessage() {
//        SmsManager smgr = SmsManager.getDefault();
//        smgr.sendTextMessage("+52",null,"GLU Helper Alert\n" +
//                "Abner Perales may need your help, location of that person:\n" +
//                "https://maps.app.goo.gl/Ztm9Hzr1kpdGME4m8?g_st=ic");
//    }

}
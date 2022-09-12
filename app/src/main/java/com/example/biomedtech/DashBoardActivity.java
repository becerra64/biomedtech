package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biomedtech.databasemodule.DataBaseHelper;
import com.example.biomedtech.dexcomAPI.DexcomAPIHelper;
import com.example.biomedtech.dexcomAPI.DexconAuthStructure;
import com.example.biomedtech.dexcomAPI.Egv;
import com.example.biomedtech.dexcomAPI.GlucoseLevel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DashBoardActivity extends AppCompatActivity {

    List<GlucoseLevel> glucoseLevels = new ArrayList<>();
    DexcomAPIHelper dexcomAPIHelper = DexcomAPIHelper.getInstance();
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        GlucoseLevel glucoseLevel = dexcomAPIHelper.getGlucoseMeasure();
        init(glucoseLevels);
        appendLevel(false);
        appendLevel(false);
        appendLevel(false);
        appendLevel(false);
        appendLevel(false);
        appendLevel(true);

    }

    public void appendLevel(boolean alarm)
    {

        if(alarm)
        {
            try {
                sendFakeMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            glucoseLevels.add(new ConsumeAPI().doInBackground(dexcomAPIHelper));
        }
    }

    public void init(List<GlucoseLevel> list){
        ItemAdapter listAdapter = new ItemAdapter(list, this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private class ConsumeAPI extends AsyncTask<DexcomAPIHelper, Void, GlucoseLevel>
    {
        @Override
        protected GlucoseLevel doInBackground(DexcomAPIHelper... apiHelper) {
            GlucoseLevel g = apiHelper[0].getGlucoseMeasure();
            return g;
        }
    }

    public void sendFakeMessage() throws InterruptedException {

        GlucoseLevel g=new GlucoseLevel();
        Egv e = new Egv();
        ArrayList<Egv> egvs = new ArrayList<>();
        e.setValue(40);
        e.setSystemTime("2022-09-11T15:40:00");
        egvs.add(e);
        g.setEgvs(egvs); //30 seconds
        glucoseLevels.add(g);
        Toast.makeText(getApplicationContext(), "Alert sent", Toast.LENGTH_SHORT).show();
        sendFakeSMS();
    }

    public void sendFakeSMS() {
        String number="+526643342262";
        String msg="GLU Helper Alert\n" +
                "Abner Perales may need your help!\n" +
                "Glucose level detected: 40 mg/dL";
        String msg2 = "Location of that person: https://maps.app.goo.gl/Ztm9Hzr1kpdGME4m8?g_st=ic";
        try {
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(number,null,msg,null,null);
            smsManager.sendTextMessage(number,null,msg2,null,null);
            Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Some fiedls is Empty",Toast.LENGTH_LONG).show();
        }
    }

}
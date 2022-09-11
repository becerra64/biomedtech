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

import com.example.biomedtech.dexcomAPI.DexcomAPIHelper;
import com.example.biomedtech.dexcomAPI.DexconAuthStructure;
import com.example.biomedtech.dexcomAPI.Egv;
import com.example.biomedtech.dexcomAPI.GlucoseLevel;

import java.io.IOException;
import java.util.ArrayList;
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
        appendLevel();
    }

    public void appendLevel()
    {
        glucoseLevels.add(new ConsumeAPI().doInBackground(dexcomAPIHelper));
    }

    public void init(List<GlucoseLevel> list){
        ItemAdapter listAdapter = new ItemAdapter(list, this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable, 1000 * 60 * 5);
                glucoseLevels.add(new ConsumeAPI().doInBackground(dexcomAPIHelper));
            }
        }, 1000 * 60 * 5);
        super.onResume();
    }

    private class ConsumeAPI extends AsyncTask<DexcomAPIHelper, Void, GlucoseLevel>
    {
        @Override
        protected GlucoseLevel doInBackground(DexcomAPIHelper... apiHelper) {
            GlucoseLevel g = apiHelper[0].getGlucoseMeasure();
            return g;
        }
    }
}
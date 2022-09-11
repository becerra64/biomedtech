package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import com.example.biomedtech.dexcomAPI.DexcomAPIHelper;
import com.example.biomedtech.dexcomAPI.DexconAuthStructure;
import com.example.biomedtech.dexcomAPI.Egv;
import com.example.biomedtech.dexcomAPI.GlucoseLevel;

import java.util.ArrayList;
import java.util.List;

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
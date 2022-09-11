package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.example.biomedtech.dexcomAPI.DexcomAPIHelper;
import com.example.biomedtech.dexcomAPI.GlucoseLevel;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {

    List<GlucoseLevel> glucoseLevels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        init(glucoseLevels);
        consumeAPI();
        consumeAPI();
        consumeAPI();
        consumeAPI();
    }

    public void init(List<GlucoseLevel> list){
        ItemAdapter listAdapter = new ItemAdapter(list, this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private void consumeAPI() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DexcomAPIHelper dexcomAPIHelper = DexcomAPIHelper.getInstance();
                        GlucoseLevel glucoseLevel = dexcomAPIHelper.getGlucoseMeasure();
                        appendGlucoseLevel(glucoseLevel);
                    }
                });
            }
        }, 1000);
    }

    public void appendGlucoseLevel(GlucoseLevel gl)
    {
        glucoseLevels.add(gl);
    }
}
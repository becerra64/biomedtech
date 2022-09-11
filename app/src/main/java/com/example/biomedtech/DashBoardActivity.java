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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        GlucoseLevel glucoseLevel = dexcomAPIHelper.getGlucoseMeasure();
        init(glucoseLevels);
        generateLog();
    }

    public void init(List<GlucoseLevel> list){
        ItemAdapter listAdapter = new ItemAdapter(list, this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void generateLog()
    {
        GlucoseLevel s = new ConsumeAPI().doInBackground(dexcomAPIHelper);
        appendGlucoseLevel(s);
    }

    public void appendGlucoseLevel(GlucoseLevel gl)
    {
        glucoseLevels.add(gl);
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
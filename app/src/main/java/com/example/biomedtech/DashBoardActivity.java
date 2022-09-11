package com.example.biomedtech;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.os.Handler;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.biomedtech.databinding.ActivityDashBoard1Binding;
import com.example.biomedtech.dexcomAPI.*;

import okhttp3.OkHttp;
import okhttp3.Response;

public class DashBoardActivity extends AppCompatActivity {

    private ActivityDashBoard1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashBoard1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_dash_board1);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //DexcomAPIHelper dexcomAPIHelper = new DexcomAPIHelper();
        //GlucoseLevel glucoseLevel = dexcomAPIHelper.getGlucoseMeasure();
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
        }, 1000 * 60 * 5);
    }


}
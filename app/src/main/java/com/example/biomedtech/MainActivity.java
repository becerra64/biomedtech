package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import com.example.biomedtech.databasemodule.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DataBaseHelper dbh = DataBaseHelper.getInstance();
        //dbh.connect();


    }

    @SuppressLint("new api")
    public void login(View view) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        DataBaseHelper DBH = DataBaseHelper.getInstance();
        DBH.connect();
    }
}
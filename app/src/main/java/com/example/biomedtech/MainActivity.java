package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import com.example.biomedtech.databasemodule.DataBaseHelper;
import com.example.biomedtech.sessionmodule.SignUpHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DataBaseHelper dbh = DataBaseHelper.getInstance();
        //dbh.connect();
        // random

    }

    @SuppressLint("new api")
    public void login(View view) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        DataBaseHelper DBH = DataBaseHelper.getInstance();
//        DBH.connect();

        Intent i = new Intent(this, DashBoardActivity.class);
        startActivity(i);
    }

    public void resetPassword(View view) {
    }

    public void createAccount(View view)
    {
        Intent i = new Intent(this, SingUpActivity.class );
        startActivity(i);

    }
}
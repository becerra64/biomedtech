package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.biomedtech.sessionmodule.SignUpHelper;

public class SingUpActivity extends AppCompatActivity {

    //global
    SignUpHelper s = SignUpHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }
}
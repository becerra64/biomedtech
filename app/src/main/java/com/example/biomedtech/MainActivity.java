package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.biomedtech.databasemodule.DataBaseHelper;
import com.example.biomedtech.sessionmodule.SignUpHelper;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    Button googleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //DataBaseHelper dbh = DataBaseHelper.getInstance();
        //dbh.connect();
        // random

        googleBtn = findViewById(R.id.googleSign);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }
        //navigateToSecondActivity();


        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            navigateToSecondActivity();
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }
    void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("new api")
    public void login(View view) {

//        DataBaseHelper DBH = DataBaseHelper.getInstance();
//        DBH.connect();

        //Intent i = new Intent(this, DashBoardActivity.class);
        //startActivity(i);

    }

    public void resetPassword(View view)
    {

    }

    public void createAccount(View view)
    {
        Intent i = new Intent(this, SingUpActivity.class );
        startActivity(i);

    }
}
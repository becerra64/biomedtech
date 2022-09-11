package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.biomedtech.sessionmodule.SignUpHelper;

public class SingUpActivity extends AppCompatActivity {

    //global
    SignUpHelper s = SignUpHelper.getInstance();
    EditText birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        birthday = (EditText) findViewById(R.id.birthday);
    }

    public void returnToLogin(View view) {
    }

    public void setBirthDay(View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog()
    {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                birthday.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}

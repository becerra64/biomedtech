package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.biomedtech.databasemodule.GetCatalogs;
import com.example.biomedtech.modelsDTO.ItemCatalog;
import com.example.biomedtech.sessionmodule.SignUpHelper;

import java.util.List;

public class SingUpActivity extends AppCompatActivity {

    //global
    SignUpHelper s = SignUpHelper.getInstance();
    EditText birthday;
    Spinner gender, nationality, use, type;
    Spinner system, useSystem, lenguage, systemContact, useSystemContact;
    Spinner useAddressContact, typeContact, genderContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        birthday = (EditText) findViewById(R.id.birthday);
        gender = (Spinner) findViewById(R.id.gender);
        nationality = (Spinner) findViewById(R.id.nationality);
        use = (Spinner) findViewById(R.id.use);
        type = (Spinner) findViewById(R.id.type);
        system = (Spinner) findViewById(R.id.system);
        useSystem = (Spinner) findViewById(R.id.useSystem);
        lenguage = (Spinner) findViewById(R.id.lenguage);
        systemContact = (Spinner) findViewById(R.id.systemContact);
        useSystemContact = (Spinner) findViewById(R.id.useSystemContact);
        useAddressContact = (Spinner) findViewById(R.id.useAddressContact);
        typeContact = (Spinner) findViewById(R.id.typeContact);
        genderContact = (Spinner) findViewById(R.id.genderContact);

        showSpinner(gender, "get_catGender");
        showSpinner(nationality, "cat_nationality");
        showSpinner(use, "get_catUseAddress");
        showSpinner(type, "get_catTypeAddress");
        showSpinner(system, "get_catSystemContact");
        showSpinner(useSystem, "get_catUseContact");
        showSpinner(lenguage, "get_catLenguage");
        showSpinner(systemContact, "get_catSystemContact");
        showSpinner(useSystemContact, "get_catUseContact");
        showSpinner(useAddressContact, "get_catUseAddress");
        showSpinner(typeContact, "get_catTypeAddress");
        showSpinner(genderContact, "get_catGender");

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

    private void showSpinner(Spinner spinner, String sp){
//        GetCatalogs getCatalogs = new GetCatalogs();
//
//        List<ItemCatalog>  listCatalog = getCatalogs.GetCatalogSP(sp);
//        ArrayAdapter<ItemCatalog> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
//                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listCatalog);
//        spinner.setAdapter(arrayAdapter);
    }
}

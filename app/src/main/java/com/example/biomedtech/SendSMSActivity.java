package com.example.biomedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {

    protected LocationManager locationManager;
    TextView coordenadas;
    TextView direccion;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsactivity);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1000, (LocationListener) this);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1000, (LocationListener) this);
        }

        button = (Button) findViewById(R.id.btnEnviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TextView co = (TextView) findViewById(R.id.txtCoordenadas);
                    TextView di = (TextView) findViewById(R.id.txtDireccion);
                    String messageToSend = co.getText().toString();
                    String messageToSend2 = di.getText().toString();
                    if (ContextCompat.checkSelfPermission(SendSMSActivity.this,
                            Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(SendSMSActivity.this,
                                Manifest.permission.SEND_SMS)) {
                            ActivityCompat.requestPermissions(SendSMSActivity.this,
                                    new String[]{Manifest.permission.SEND_SMS}, 1);
                        } else {
                            ActivityCompat.requestPermissions(SendSMSActivity.this,
                                    new String[]{Manifest.permission.SEND_SMS}, 1);
                        }
                    } else {
                        String number = "6641337777";
                        SmsManager.getDefault().sendTextMessage(number, null, messageToSend2 + "n" +
                                messageToSend, null, null);
                    }
                    Toast.makeText(getApplicationContext(), "Mensaje Enviado!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Fallo el envio!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }
}
package com.example.subir.interviewapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText otp;
    Button btnSend;
    int otpGenerate;
    String otpuniverse[] = new String[10];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        Intent j = getIntent();
        otpuniverse = j.getStringArrayExtra("completeDataForSave");

        btnSend = findViewById(R.id.btnSubmit);
        otp = findViewById(R.id.otpField);

        btnSend.setOnClickListener(this);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"Permission Not Granted",
                    Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1725);
            btnSend.setEnabled(false);
        }
        else {
            btnSend.setEnabled(true);
        }

        smssender();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1725 &&
                grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"Permission has been Granted",
                    Toast.LENGTH_SHORT).show();
            btnSend.setEnabled(true);
            Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
        }
        else
        {
            btnSend.setEnabled(false);
        }
    }

    public void smssender()
    {
        Random r = new Random();
        otpGenerate = r.nextInt((999999 - 111111) + 1) + 111111;

        String msg = "Your One time password for registering is "+otpGenerate+". Please do not share this " +
                "message with anyone.";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(otpuniverse[3],
                null, msg,null, null);
    }

    @Override
    public void onClick(View v) {

        if (Integer.toString(otpGenerate).equals(otp.getText().toString())){
            //db operation for insert
            Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.subir.interviewapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DataCheck extends AppCompatActivity implements View.OnClickListener {

    String universe[] = new String[10];
    TextView t;
    FloatingActionButton submitData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datacheck);

        Intent j = getIntent();
        universe = j.getStringArrayExtra("completeData");

        t = findViewById(R.id.usernameCnf);
        t.setText(universe[0]);

        t = findViewById(R.id.emailCnf);
        t.setText(universe[2]);

        t = findViewById(R.id.phonenoCnf);
        t.setText(universe[3]);

        t = findViewById(R.id.collegeCnf);
        t.setText(universe[4]);

        t = findViewById(R.id.courseCnf);
        t.setText(universe[5]);

        submitData = findViewById(R.id.submitCnf);

        submitData.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() { }

    @Override
    public void onClick(View v) {
        openAlert();
    }

    public void openAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DataCheck.this);

        alertDialogBuilder.setTitle("Confirmation");
        alertDialogBuilder.setMessage("Are you sure?");
        alertDialogBuilder.setIcon(R.drawable.ic_done_all_black_24dp);

        alertDialogBuilder.setPositiveButton("Yes, Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(DataCheck.this, OtpActivity.class);
                i.putExtra("completeDataForSave", universe);
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No, Go Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(DataCheck.this, SignUpActivity.class);
                i.putExtra("completeDataReturn", universe);
                startActivity(i);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}

package com.example.subir.interviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    String[] universe = new String[10];
    String[] universeReturn = new String[10];
    String str;
    EditText e;
    FloatingActionButton submitData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent j = getIntent();
        universeReturn = j.getStringArrayExtra("completeDataReturn");

        if (universeReturn!=null) {
            e = findViewById(R.id.usernameReg);
            str = universeReturn[0];
            e.setText(str);
            e = findViewById(R.id.emailReg);
            str = universeReturn[2];
            e.setText(str);
            e = findViewById(R.id.phonenoReg);
            str = universeReturn[3];
            e.setText(str);
            e = findViewById(R.id.collegeReg);
            str = universeReturn[4];
            e.setText(str);
            e = findViewById(R.id.courseReg);
            str = universeReturn[5];
            e.setText(str);
        }


        submitData = findViewById(R.id.signupReg);
        submitData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        universe[0] = ((EditText)(findViewById(R.id.usernameReg))).getText().toString();
        universe[1] = ((EditText)(findViewById(R.id.passwordReg))).getText().toString();
        universe[2] = ((EditText)(findViewById(R.id.emailReg))).getText().toString();
        universe[3] = ((EditText)(findViewById(R.id.phonenoReg))).getText().toString();
        universe[4] = ((EditText)(findViewById(R.id.collegeReg))).getText().toString();
        universe[5] = ((EditText)(findViewById(R.id.courseReg))).getText().toString();

        boolean dataValidator = false;
        if (!(universe[0].isEmpty() ||
                universe[1].isEmpty()||
                universe[2].isEmpty() ||
                universe[3].isEmpty() ||
                universe[4].isEmpty() ||
                universe[5].isEmpty())){
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
            if(universe[1].matches(pattern)){
                dataValidator = true;
            }
            else{
                Toast.makeText(getApplicationContext(),"Password must contain one UPPERCASE " +
                        "LETTER one numeral one spacial character and must be longer " +
                        "than eight characters",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Fields cannot be empty",
                    Toast.LENGTH_SHORT).show();
        }


        if(dataValidator) {
            Intent i = new Intent(SignUpActivity.this, DataCheck.class);
            i.putExtra("completeData", universe);
            startActivity(i);
        }
    }
}

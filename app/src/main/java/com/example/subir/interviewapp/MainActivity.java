package com.example.subir.interviewapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText user,pwd;
    TextView signup;
    FloatingActionButton login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //card view k andar jo text view hai uska background set krna hai aur rounded edges dena hai
        //but ye run kr raha hai. phone pe run kr raha hai.

        user = findViewById(R.id.usernameHome);
        pwd = findViewById(R.id.passwordHome);
        signup = findViewById(R.id.registerHome);
        login = findViewById(R.id.loginHome);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginHome) {
            //login
            if (user.getText().equals(null) || (pwd.getText().equals(null))) {
                Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT)
                        .show();
            } else {

            }
        }
        else{
            //signup
            Intent i = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(i);
        }

    }
}

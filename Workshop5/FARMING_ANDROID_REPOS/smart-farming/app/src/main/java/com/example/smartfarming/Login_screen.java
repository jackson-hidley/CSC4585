package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login_screen extends AppCompatActivity {
    TextView tvfp,tvlogin,tvsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        tvfp=(TextView)findViewById(R.id.tvfp);
        tvlogin=(TextView)findViewById(R.id.tvlogin);
        tvsignup=(TextView)findViewById(R.id.tvsignup);

        tvfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login_screen.this,Forgotpsw_screen.class);
                startActivity(i);
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login_screen.this,Dashboard_screen.class);
                startActivity(i);
            }
        });

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login_screen.this,Signup_screen.class);
                startActivity(i);
            }
        });
    }
}
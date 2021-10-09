package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup_screen extends AppCompatActivity {
    TextView tvsu,tvli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        tvsu=(TextView)findViewById(R.id.tvsu);
        tvli=(TextView)findViewById(R.id.tvli);

        tvsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Signup_screen.this,Login_screen.class);
                startActivity(i);
            }
        });

        tvli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Signup_screen.this,Login_screen.class);
                startActivity(i);
            }
        });
    }
}
package com.example.nameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    private String mName;
    private TextView mTextViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mTextViewName= findViewById(R.id.textview_name);

        initView();

    }

    private void initView() {

        Bundle bundle= getIntent().getExtras();
        mName= bundle.getString("name");

        mTextViewName.setText("Hello, "+mName);

    }
}
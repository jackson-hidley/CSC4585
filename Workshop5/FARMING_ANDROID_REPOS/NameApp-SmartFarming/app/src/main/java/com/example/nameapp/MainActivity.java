package com.example.nameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mButtonNext;
    private EditText mEditTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonNext= findViewById(R.id.button_next);
        mEditTextName= findViewById(R.id.edittext_name);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNameActivity();
            }
        });
    }

    private void goToNameActivity() {
        String name= mEditTextName.getText().toString();

        Intent intent= new Intent(this, NameActivity.class);
        intent.putExtra("name", name);

        startActivity(intent);

    }
}
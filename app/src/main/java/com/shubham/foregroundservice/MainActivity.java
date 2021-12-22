package com.shubham.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button start,stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.btnStart);
        stop=findViewById(R.id.btnStop);
        editText=findViewById(R.id.welcome);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = editText.getText().toString().trim();
                Intent service = new Intent(MainActivity.this,Services.class);
                service.putExtra("inputExtra", edit);
                ContextCompat.startForegroundService(MainActivity.this, service);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent serviceIntent = new Intent(MainActivity.this, Services.class);
                stopService(serviceIntent);
            }
        });
    }
}
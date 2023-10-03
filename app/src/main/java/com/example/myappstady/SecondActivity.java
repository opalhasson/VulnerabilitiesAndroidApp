package com.example.myappstady;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends Activity {
    private TextView text;
    private String tx;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text = findViewById(R.id.text_second);
        tx = getIntent().getStringExtra("CVEid");

        text.setText(tx);
    }
}

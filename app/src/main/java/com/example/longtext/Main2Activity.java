package com.example.longtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tvShowMassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvShowMassage=(TextView) findViewById(R.id.tvShowMassage);
        String massage=getIntent().getStringExtra("ma");

        tvShowMassage.setText(massage);
    }
}

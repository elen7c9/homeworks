package com.dz.elen.homeworks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Homework4_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ClockView(this));
    }
}

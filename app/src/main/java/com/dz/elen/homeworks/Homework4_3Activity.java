package com.dz.elen.homeworks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Homework4_3Activity extends AppCompatActivity {

    float[] array = {500,800,300,400};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PieChartView(this, array));
    }
}

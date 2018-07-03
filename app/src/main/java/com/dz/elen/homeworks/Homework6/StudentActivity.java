package com.dz.elen.homeworks.Homework6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.dz.elen.homeworks.R;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ImageView imageView = (ImageView) findViewById(R.id.imgView);
    }
}

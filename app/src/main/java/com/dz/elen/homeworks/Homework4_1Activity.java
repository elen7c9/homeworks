package com.dz.elen.homeworks;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.leakcanary.LeakCanary;

public class Homework4_1Activity extends AppCompatActivity {

    ImageView iv_sova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4_1);

        iv_sova=(ImageView)findViewById(R.id.iv_sova);
        iv_sova.setBackgroundResource(R.drawable.sova_animation);
        final AnimationDrawable progressAnimation =(AnimationDrawable)iv_sova.getBackground();
        progressAnimation.start();
    }


}




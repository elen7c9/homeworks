package com.dz.elen.homeworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dz.elen.homeworks.Homework6.ListOfStudentsActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnHomework1 = (Button) findViewById(R.id.btnHomework1);
        btnHomework1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework1Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mycombo,R.anim.myalpha);
            }
        });

        Button btnHomework2 = (Button) findViewById(R.id.btnHomework2);
        btnHomework2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.myscale,R.anim.myalpha);
            }
        });

        Button btnHomework3 = (Button) findViewById(R.id.btnHomework3);
        btnHomework3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework3Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.mytrans,R.anim.myalpha);
            }
        });

        Button btnHomework4_1 = (Button) findViewById(R.id.btnHomework4_1);
        btnHomework4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework4_1Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.myscale,R.anim.myalpha);
            }
        });

        Button btnHomework4_2 = (Button) findViewById(R.id.btnHomework4_2);
        btnHomework4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework4_2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.myscale,R.anim.myalpha);
            }
        });

        Button btnHomework4_3 = (Button) findViewById(R.id.btnHomework4_3);
        btnHomework4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework4_3Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.myscale,R.anim.myalpha);
            }
        });

        Button btnHomework5 = (Button) findViewById(R.id.btnHomework5);
        btnHomework5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework5Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.myscale,R.anim.myalpha);
            }
        });

        Button btnHomework6 = (Button) findViewById(R.id.btnHomework6);
        btnHomework6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, ListOfStudentsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.myscale,R.anim.myalpha);
            }
        });
    }
}

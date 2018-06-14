package com.dz.elen.homeworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            }
        });

        Button btnHomework2 = (Button) findViewById(R.id.btnHomework2);
        btnHomework2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework2Activity.class);
                startActivity(intent);
            }
        });

        Button btnHomework3 = (Button) findViewById(R.id.btnHomework3);
        btnHomework3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, Homework3Activity.class);
                startActivity(intent);
            }
        });
    }
}

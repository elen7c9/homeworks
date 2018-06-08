package com.example.elen.dz1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dz1Activity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1;
    TextView textView2;
    Button button;
    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz1);

        textView1=(TextView) findViewById(R.id.str1);
        textView2=(TextView) findViewById(R.id.str2);
        temp = (TextView) findViewById(R.id.temp);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                temp.setText(textView1.getText().toString());

                textView1.setText(textView2.getText().toString());
                textView2.setText(temp.getText().toString());
            }
        });


        textView1.setOnClickListener(this);

    }
    public void clickStr2(View view){
        temp.setText(textView1.getText().toString());
        textView1.setText(textView2.getText().toString());
        textView2.setText(temp.getText().toString());
    }

    @Override
    public void onClick(View view) {
        temp.setText(textView1.getText().toString());
        textView1.setText(textView2.getText().toString());
        textView2.setText(temp.getText().toString());
    }
}

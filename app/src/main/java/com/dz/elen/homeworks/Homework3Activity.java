package com.dz.elen.homeworks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Homework3Activity extends AppCompatActivity {

    ImageView img;
    Button btn;
    Button btnBack;
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);

        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.btnLoad);
        url=(EditText) findViewById(R.id.imgUrl);
        btnBack = (Button) findViewById(R.id.btnBack3);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Picasso.get().load(url.getText().toString()).into(img);

                }
            });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homework3Activity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }
}

package com.dz.elen.homeworks.Homework6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

public class StudentActivity extends AppCompatActivity {

    TextView nameTxt, mailTxt;
    ImageView imgView;

    String name, mail;
    int img, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        nameTxt = (TextView) findViewById(R.id.nameViewDetail);
        mailTxt = (TextView) findViewById(R.id.mailViewDetail);
        imgView = (ImageView) findViewById(R.id.imgViewDetail);

        Intent intent = this.getIntent();
        name = intent.getExtras().getString("NEME_KEY");
        mail = intent.getExtras().getString("MAIL_KEY");
        img = intent.getExtras().getInt("IMG_KEY");
        pos = intent.getExtras().getInt("POS_KEY");

        nameTxt.setText(name);
        mailTxt.setText(mail);
        imgView.setImageResource(img);





    }
}

package com.dz.elen.homeworks.Homework6;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

public class StudentActivity extends AppCompatActivity {

    TextView nameTxt, mailTxt;
    ImageView imgView;

    String name, mail;
    int img, pos;

    EditText nameEditText, mailEditText;
    Button editBtn, deleteBtn, saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DetailFragment fragment = new DetailFragment();
        fragmentTransaction.add(R.id.detail_fragment, fragment);
        fragmentTransaction.commit();*/

        nameTxt = (TextView) findViewById(R.id.nameViewDetail);
        mailTxt = (TextView) findViewById(R.id.mailViewDetail);
        imgView = (ImageView) findViewById(R.id.imgViewDetail);

        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        editBtn = (Button) findViewById(R.id.editBtn);


        Intent intent = this.getIntent();
        name = intent.getExtras().getString("NAME_KEY");
        mail = intent.getExtras().getString("MAIL_KEY");
        img = intent.getExtras().getInt("IMG_KEY");
        pos = intent.getExtras().getInt("POS_KEY");

        nameTxt.setText(name);
        mailTxt.setText(mail);
        imgView.setImageResource(img);


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(StudentsBase.get().delete(pos)){
                    StudentActivity.this.finish();
                }
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayEditDialog();
            }
        });

    }
    private void displayEditDialog(){


        final Dialog d = new Dialog(this);
        d.setTitle("ADD NEW STUDENT");
        d.setContentView(R.layout.edit_dialog);
        nameEditText = (EditText) d.findViewById(R.id.nameEditText);
        mailEditText = (EditText) d.findViewById(R.id.mailEditText);

        //editBtn = (Button) d.findViewById(R.id.editBtn);
        //deleteBtn = (Button) d.findViewById(R.id.deleteBtn);
        saveBtn = (Button) d.findViewById(R.id.saveBtn);

        nameEditText.setText(name);
        mailEditText.setText(mail);
        imgView.setImageResource(img);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student s = new Student();

                name = nameEditText.getText().toString();
                s.setName(name);

                mail = mailEditText.getText().toString();
                s.setMail(mail);

                s.setImage(img);

                if(StudentsBase.get().edit(pos,s)){
                    nameEditText.setText(name);
                    mailEditText.setText(mail);



                    nameTxt.setText(name);
                    mailTxt.setText(mail);
                    imgView.setImageResource(img);
                    //imgView.setImageResource(R.drawable.noimage);
                }
                d.dismiss();
            }
        });
        d.show();
    }
}

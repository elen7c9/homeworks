package com.dz.elen.homeworks;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homework1Activity extends AppCompatActivity implements View.OnClickListener{

    TextView textView1;
    TextView textView2;
    Button button;
    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1);

        textView1=(TextView) findViewById(R.id.str1);
        textView2=(TextView) findViewById(R.id.str2);
        temp = (TextView) findViewById(R.id.temp);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                changeString();
            }
        });


        textView1.setOnClickListener(this);

    }
    public void clickStr2(View view){
        changeString();
    }


    public void onClick(View view) {
        changeString();
    }

    public  void  changeString(){

        temp.setText(textView1.getText().toString());
        ColorDrawable cdTemp = (ColorDrawable) textView1.getBackground();
        int colorCodeTemp = cdTemp.getColor();
        temp.setBackgroundColor(colorCodeTemp);

        textView1.setText(textView2.getText().toString());
        ColorDrawable cd1 = (ColorDrawable) textView2.getBackground();
        int colorCode1 = cd1.getColor();
        textView1.setBackgroundColor(colorCode1);

        textView2.setText(temp.getText().toString());
        ColorDrawable cd2 = (ColorDrawable) temp.getBackground();
        int colorCode2 = cd2.getColor();
        textView2.setBackgroundColor(colorCode2);

    }

}

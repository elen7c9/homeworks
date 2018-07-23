package com.dz.elen.homeworks.HomeworkRx;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

public class DzRxActivity extends AppCompatActivity {

     int count = 0;
    Button btnClick;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz_rx);

        btnClick = (Button)findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
            }
        });

        CountFragment countFragment= new CountFragment(count);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragmCount,countFragment);
        fragmentTransaction.commit();


    }



}

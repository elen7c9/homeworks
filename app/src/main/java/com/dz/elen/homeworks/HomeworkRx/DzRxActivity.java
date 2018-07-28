package com.dz.elen.homeworks.HomeworkRx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dz.elen.homeworks.R;


public class DzRxActivity extends FragmentActivity {

    Button btnClick;
    CountFragment countFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzrx);

        btnClick = (Button)findViewById(R.id.btnClick);
        countFragment = new CountFragment();



        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(countFragment, true);
                countFragment.incrementValue();
            }
        });

    }

    private void showFragment(final Fragment fragment, boolean addToBaskStack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment, fragment.getClass().getSimpleName());
        transaction.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}

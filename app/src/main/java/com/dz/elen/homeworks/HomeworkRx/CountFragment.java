package com.dz.elen.homeworks.HomeworkRx;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dz.elen.homeworks.R;


public class CountFragment extends Fragment {

    private int counter;
    private TextView countTextView;



    public CountFragment() {
    }

    @SuppressLint("ValidFragment")
    public CountFragment(int counter) {
        this.counter = counter;
    }

    public static CountFragment newInstance(int counter) {
        CountFragment myFragment = new CountFragment();
        Bundle args = new Bundle();
        args.putInt("count", counter);
        myFragment.setArguments(args);
        return myFragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            counter = bundle.getInt("count");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_count, container, false);
        countTextView = (TextView) view.findViewById(R.id.textCount);

        readBundle(getArguments());


        countTextView.setText(String.valueOf(counter));

        return view;
    }

  /*  @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments().getInt("someInt", counter);

    }*/


}

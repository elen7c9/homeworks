package com.dz.elen.homeworks.HomeworkRx;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static java.util.concurrent.TimeUnit.SECONDS;


public class CountFragment extends Fragment {

    TextView countByClick;
    TextView timerCount;

    Observable<String> timer;
    Disposable disposable;
    AtomicInteger lastValue = new AtomicInteger(0);
    View view;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timer = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> 1)
                .startWith(Observable.fromCallable(lastValue::get))
                .scan((current,next) -> current + next)
                .filter(i -> i % 2 == 0)
                .doOnNext(lastValue::set)
                .map(i -> Integer.toString(i))
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_count,container,false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countByClick = (TextView) view.findViewById(R.id.textCountByClick);
        timerCount = (TextView) view.findViewById(R.id.timerCount);

    }

    @Override
    public void onPause() {
        super.onPause();
        disposable.dispose();

    }

    @Override
    public void onResume() {
        super.onResume();
        disposable = timer.subscribe(s -> timerCount.setText(s));

    }

    @Override
    public void onStop() {
        super.onStop();
        disposable.dispose();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getContext();
    }


    public void incrementValue() {
        if (countByClick != null) {
            countByClick.setText(String.valueOf(Integer.valueOf(countByClick.getText().toString()) +1));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity();
    }

}

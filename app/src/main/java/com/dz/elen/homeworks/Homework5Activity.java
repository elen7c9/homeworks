package com.dz.elen.homeworks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

public class Homework5Activity extends AppCompatActivity {

    TextView wifiState;
    WifiManager wifiManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);

        wifiState = (TextView)findViewById(R.id.wifiState);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {

            int wifiExtraState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE , WifiManager.WIFI_STATE_UNKNOWN);

            switch(wifiExtraState){
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiState.setText("WIFI IS OFF");
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiState.setText("WIFI IS ON");
                    break;
            }

        }};



}

package com.dz.elen.homeworks;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class Homework5Activity extends AppCompatActivity {

    TextView wifiState;
    WifiManager wifiManager;
    Button btn;

    MyService myService;
    boolean mBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);

        wifiState = (TextView)findViewById(R.id.wifiState);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        btn = (Button) findViewById(R.id.btnWifiState);

    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
        // Bind to MyService
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
        // Unbind from the service
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }


    public void onClick(View v) {
        if (mBound) {
             myService.onClickButton();
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            myService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {

            wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

            if ( !wifiManager.isWifiEnabled()) {
                wifiState.setText("WIFI IS OFF");
                wifiState.setTextColor(Color.RED);
            }

            else if (wifiManager.isWifiEnabled()) {
                wifiState.setText("WIFI IS ON");
                wifiState.setTextColor(Color.DKGRAY);
            }
        }};
}

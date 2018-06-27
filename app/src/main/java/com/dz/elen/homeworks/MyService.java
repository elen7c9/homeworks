package com.dz.elen.homeworks;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MyService extends Service {

    final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void onClickButton(){
        WifiManager wifiManager = (WifiManager) this .getSystemService(Context.WIFI_SERVICE);

        if ( !wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }

        else if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);

        }
    }

}

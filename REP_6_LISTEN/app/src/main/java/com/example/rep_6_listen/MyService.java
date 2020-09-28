package com.example.rep_6_listen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread thread;
    Intent myIntento;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MI SERVICIO","onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("MI SERVICIO","onStart");



        thread = new Thread(){

            @Override
            public void run() {
                super.run();

                while (true){
                    try {
                        Thread.sleep(1000);
                        //  Log.wtf("MISERVICIO","THREAD");

                        myIntento = new Intent("MI_SERVICIO");
                        //myIntento.putExtra
                        sendBroadcast(myIntento);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        thread.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MI SERVICIO","onDestroy");

        thread.interrupt();

    }
}

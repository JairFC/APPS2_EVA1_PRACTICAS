package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {


    Intent inServicio;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        inServicio = new Intent(this, MyService.class);

        BroadcastReceiver broadcastReceiver = new myBroadCastReciver();

        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");

        registerReceiver(broadcastReceiver,intentFilter);



    }


    public void iniciar(View view){
        inServicio.putExtra("DATO","Dato de la actividad!!");
        startService(inServicio);
    }

    public void detener(View view){
        stopService(inServicio);
    }


    class myBroadCastReciver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //PROCESAMOS EL MESNAJE
            Log.wtf("MENSAJE","THREAD");


        }
    }

}
package com.example.rep_5_segeunda_parte_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv1);


        BroadcastReceiver broadcastReceiver = new myBroadCastReciver();

        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");

        registerReceiver(broadcastReceiver,intentFilter);
    }




    class myBroadCastReciver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //PROCESAMOS EL MESNAJE
            textView.append(intent.getStringExtra("ENVIADOS"));


        }
    }
}
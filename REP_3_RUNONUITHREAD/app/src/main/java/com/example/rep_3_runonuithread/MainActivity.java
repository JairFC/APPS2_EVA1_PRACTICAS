package com.example.rep_3_runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //aquí modificamos la interfaz grafica
            tv1.append("hellow hell!! \n");
        }
    };

    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            for (int i=0; i<=10;i++){
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tvText1);
        thread.start();
    }
}
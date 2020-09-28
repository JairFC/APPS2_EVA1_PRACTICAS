package com.example.eva1_4_frag_parametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearFragment(View v){
        //transaccion
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        //crear fragmento
        ParamFragment paramFragment = ParamFragment.newInstance("Hola mundoo!!","Valores asignados al fragmento");
        //remplazar nuestro layout fr lay x frag
        ft.replace(R.id.frmLyFrag,paramFragment);
        //comit
        ft.commit();
    }
}
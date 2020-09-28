package com.example.eva1_2_cominicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1. RECUPERAR LOS FRAGMENTOS

    ListFragment lista;
    DataFragment datos;

    //2. ACCEDER
    //METODO QUE SE EJECUTA CUANDO UN FRAGMENTO SE VINCULA


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment.getClass()==ListFragment.class)
            lista = (ListFragment) fragment;
        else if (fragment.getClass() == DataFragment.class)
            datos = (DataFragment) fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    //INTERFAZ DE COMNUNICACIÓN
    public void onMessageFromFragToMain(String sender,String param){
        if (sender.equals("LISTA")){
            //ENVIAR PARAMETRO
            datos.onMessageFromMainToFrag(param);
        }else if (sender.equals("DATA")){
            Toast.makeText(this, param, Toast.LENGTH_SHORT).show();
        }
    }
}
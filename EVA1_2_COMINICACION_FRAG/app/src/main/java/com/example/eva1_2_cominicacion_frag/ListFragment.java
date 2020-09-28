package com.example.eva1_2_cominicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class ListFragment extends Fragment {

    //Datos de la lista

    String[] datos = {
      "Enero",
      "Febrero",
      "Marzo",
      "Abril",
      "Mayo",
      "Junio",
      "Julio",
      "Agosto",
      "Diciembre",
      "Enero2",
      "Febrero2",
      "Marzo4",
      "Abril5",
      "Mayo6",
    };


    MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_list, container, false);
        //Aqui llenamos la lista
        ListView listView;
        listView = frameLayout.findViewById(R.id.lvData);
        listView.setAdapter(new ArrayAdapter<>(
                mainActivity,
                android.R.layout.simple_list_item_1,
                datos
        ));
        //evento
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //aqui va el codigo
                mainActivity.onMessageFromFragToMain("LISTA",datos[i]);
            }
        });
        return frameLayout;
    }
}
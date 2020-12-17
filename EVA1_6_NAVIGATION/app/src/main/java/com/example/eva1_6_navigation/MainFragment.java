package com.example.eva1_6_navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Button btnRed,btnBlue;

        btnBlue = view.findViewById(R.id.btnblue);
        btnRed = view.findViewById(R.id.btnred);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Prueba","Hello Hell!!");
               MainFragmentDirections.ActionMainFragment2ToRedFragment2 action =
                       MainFragmentDirections.actionMainFragment2ToRedFragment2();
             //  action.setMiValor(99999);
               navController.navigate(action);
                // navController.navigate(R.id.action_mainFragment2_to_redFragment2, bundle);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_mainFragment2_to_blueFragment2);
            }
        });
    }
}
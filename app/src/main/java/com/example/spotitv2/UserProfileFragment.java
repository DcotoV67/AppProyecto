package com.example.spotitv2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import life.sabujak.roundedbutton.RoundedButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {


    public UserProfileFragment() {
        // Required empty public constructor
    }
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        RoundedButton btn_guardar_cambios = view.findViewById(R.id.modifyProfile);

        btn_guardar_cambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gestionarSpotActivity = new Intent(MainActivity.this, gestionarSpotActivity.class);
//                startActivity(gestionarSpotActivity);

                //Aqui elegimos a que fragment navegar
                Navigation.findNavController(view).navigate(R.id.homeFragment);
                Toast.makeText(getActivity(), "Cambios Guardados", Toast.LENGTH_LONG).show();
            }
        });

    }
}

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
public class SeeSpotFragment extends Fragment {


    public SeeSpotFragment() {
        // Required empty public constructor
    }

    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_see_spot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        RoundedButton btn_delete_spot = view.findViewById(R.id.btn_delete_spot);

        btn_delete_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.homeFragment);
                Toast.makeText(getActivity(), "Spot eliminado con éxito",Toast.LENGTH_LONG).show();
            }
        });
    }
}

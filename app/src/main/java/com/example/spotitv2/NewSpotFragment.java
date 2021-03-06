package com.example.spotitv2;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Map;

import life.sabujak.roundedbutton.RoundedButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewSpotFragment extends Fragment {

    public static final int PICK_IMAGE = 1;
    public static final int PICK_LOCATION = 1;
    ImageView spotImageView;
    TextView ubicacionMapa;


    public NewSpotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_spot, container, false);

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RoundedButton btn_add_spot_img = view.findViewById(R.id.button_img);
        RoundedButton btn_add_spot_map = view.findViewById(R.id.button_map);
        RoundedButton btn_create_spot = view.findViewById(R.id.btn_create_spot);

        ubicacionMapa = view.findViewById(R.id.ubicacionMapa);

        spotImageView = view.findViewById(R.id.spot_gallery_img);


        //Accion del boton add img
        btn_add_spot_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chooseImage();


            }
        });

        //Accion del boton add map
        btn_add_spot_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MapsActivity = new Intent(getActivity(), MapsActivity.class);
                startActivityForResult(MapsActivity, PICK_LOCATION);

            }

        });

        btn_create_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.seeSpotFragment);
                Toast.makeText(getActivity(), "Spot creado con éxito",Toast.LENGTH_LONG).show();
            }
        });

    }



    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && data != null && data.getData() != null) {

            Uri uri = data.getData();

            Glide.with(requireActivity()).load(uri).into(spotImageView);
        }
    }
}


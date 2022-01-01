package com.example.aplikasiteknisionlinegarut;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;



public class home extends Fragment {

    public static Boolean tek_hp, tek_motor, tek_mobil, tek_alatrumah, tek_print, tek_tv, tek_pc, tek_alatmusik;
    private ImageButton thp, tmotor, tmobil, talatrumah, tprint, ttv, tpc, talatmusik;
    public home() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        thp = view.findViewById(R.id.tehp);
        tmotor = view.findViewById(R.id.temotor);
        tmobil = view.findViewById(R.id.temobil);
        talatmusik = view.findViewById(R.id.tealatmusikvideo);
        talatrumah = view.findViewById(R.id.tealatrumah);
        tprint = view.findViewById(R.id.teprint);
        tpc = view.findViewById(R.id.tepc);
        ttv = view.findViewById(R.id.tetv);

        thp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = true;
                tek_motor = false;
                tek_mobil = false;
                tek_alatmusik = false;
                tek_alatrumah = false;
                tek_print = false;
                tek_pc = false;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        tmotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_motor = true;
                tek_hp = false;
                tek_mobil = false;
                tek_alatmusik = false;
                tek_alatrumah = false;
                tek_print = false;
                tek_pc = false;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        tmobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = false;
                tek_motor = false;
                tek_mobil = true;
                tek_alatmusik = false;
                tek_alatrumah = false;
                tek_print = false;
                tek_pc = false;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        talatmusik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = false;
                tek_motor = false;
                tek_mobil = false;
                tek_alatmusik = true;
                tek_alatrumah = false;
                tek_print = false;
                tek_pc = false;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        talatrumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = false;
                tek_motor = false;
                tek_mobil = false;
                tek_alatmusik = false;
                tek_alatrumah = true;
                tek_print = false;
                tek_pc = false;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        tprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = false;
                tek_motor = false;
                tek_mobil = false;
                tek_alatmusik = false;
                tek_alatrumah = false;
                tek_print = true;
                tek_pc = false;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        tpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = false;
                tek_motor = false;
                tek_mobil = false;
                tek_alatmusik = false;
                tek_alatrumah = false;
                tek_print = false;
                tek_pc = true;
                tek_tv = false;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        ttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tek_hp = false;
                tek_motor = false;
                tek_mobil = false;
                tek_alatmusik = false;
                tek_alatrumah = false;
                tek_print = false;
                tek_pc = false;
                tek_tv = true;
                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}

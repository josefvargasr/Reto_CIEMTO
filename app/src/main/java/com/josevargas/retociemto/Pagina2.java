package com.josevargas.retociemto;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Pagina2 extends Fragment {

    TextView tPagina2;
    Button bVolver;
    String nveces,nveces2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_pagina2,container, false);

        tPagina2 = (TextView) mLinearLayout.findViewById(R.id.tPagina2);
        bVolver = (Button) mLinearLayout.findViewById(R.id.bVolver);
        nveces = getArguments().getString("edttext");
        nveces2 = getArguments().getString("edttext2");
        tPagina2.setText(nveces);

        bVolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putString("edttext", nveces2);

                Pagina1 fragment1 = new Pagina1();
                fragment1.setArguments(bundle);
                fragmentTransaction.replace(android.R.id.content, fragment1).commit();
            }
        });

        return mLinearLayout;
    }


}

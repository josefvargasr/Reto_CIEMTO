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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Pagina1 extends Fragment {

    TextView data_veces;
    EditText eTexto;
    Button bSigPg;
    String nveces;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_pagina1,container, false);

        data_veces = (TextView) mLinearLayout.findViewById(R.id.tVeces);
        eTexto = (EditText) mLinearLayout.findViewById(R.id.eTexto);
        bSigPg = (Button) mLinearLayout.findViewById(R.id.bSigPg);
        nveces = getArguments().getString("edttext");
        data_veces.setText(nveces);

        bSigPg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(eTexto.getText())){
                    Toast.makeText(getActivity(), getResources().getString(R.string.toastcampos), Toast.LENGTH_SHORT).show();
                }else {
                    String s = eTexto.getText().toString();
                    int l = (s).length();
                    int ch = 0, in = 0;
                    StringBuilder ch0 =new StringBuilder(100);
                    StringBuilder in0 =new StringBuilder(100);
                    for (int i = 0;i < l;i++){
                        if(Character.isDigit(s.charAt(i))){
                            in++;
                            in0.append(s.charAt(i));
                        }else{
                            ch++;
                            ch0.append(s.charAt(i));
                        }
                    }
                    StringBuilder s1 =new StringBuilder(200);
                    if(ch == l){
                        s1.append(nveces+"\nCaracteres:\n"+s);
                    }else if(in == l){
                        int n = Integer.valueOf(nveces);
                        int b = Integer.valueOf(s);
                        s1.append(nveces+"\nSuma:\n"+String.valueOf(n+b)+"\nResta:\n"+String.valueOf(b-n)+"\nMultiplicacion:\n"+String.valueOf(b*n)+"\nDivision:\n"+String.valueOf(b/n));
                    }else{
                        s1.append(nveces+"\nCaracteres:\n"+ch0+"\nNumeros:\n"+in0);
                    }

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    Bundle bundle = new Bundle();
                    bundle.putString("edttext", s1.toString());
                    bundle.putString("edttext2", nveces);
                    Pagina2 fragment2 = new Pagina2();
                    fragment2.setArguments(bundle);
                    fragmentTransaction.replace(android.R.id.content, fragment2).commit();
                }
            }
        });

        return mLinearLayout;
    }

}

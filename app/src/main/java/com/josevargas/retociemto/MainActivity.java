package com.josevargas.retociemto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    int v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getPreferences(MODE_PRIVATE);
        editor = prefs.edit();
        v = prefs.getInt("nveces", 0) + 1;
        editor.putInt("nveces", v);
        editor.commit();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("edttext", Integer.toString(v));

        Pagina1 fragment1 = new Pagina1();
        fragment1.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content, fragment1).commit();
    }

}

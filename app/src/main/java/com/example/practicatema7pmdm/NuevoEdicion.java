package com.example.practicatema7pmdm;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practicatema7pmdm.Logic.LogicLugar;

public class NuevoEdicion extends AppCompatActivity {
    EditText edit1, edit2, edit3, edit4;
    RatingBar rb;
    Spinner spinner;
    String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_edicion);
        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);
        edit3 = findViewById(R.id.editText3);
        edit4 = findViewById(R.id.editText4);
        spinner =findViewById(R.id.spinner2);
        rb = findViewById(R.id.ratingBar2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        App.lugarActivo.setNombre(edit1.getText().toString());
        App.lugarActivo.setLatitud(Float.parseFloat(edit3.getText().toString()));
        App.lugarActivo.setLongitud(Float.parseFloat(edit2.getText().toString()));
        App.lugarActivo.setComentarios(edit4.getText().toString());
        App.lugarActivo.setValoracion(rb.getRating());
        App.lugarActivo.setCategoria(spinner.getSelectedItemPosition());
        LogicLugar.insertarLugar(this, App.lugarActivo );
        Toast.makeText(this, getResources().getString(R.string.toast1), Toast.LENGTH_SHORT).show();
        return false;
    }
}
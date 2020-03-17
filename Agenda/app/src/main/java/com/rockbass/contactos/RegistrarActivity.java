package com.rockbass.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistrarActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellidoPaterno, editTextApellidoMaterno,
            editTextEdad, editTextTelefono, editTextEmail, editTextContConfianza;
    Spinner comboContactos;
    String[] strContactos;
    List<String> listaNom;
    ArrayAdapter<String> comboAdapter;
    String nombreContacto;
    Spinner contactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellidoPaterno = findViewById(R.id.editTextApellidoPaterno);
        editTextApellidoMaterno = findViewById(R.id.editTextApellidoMaterno);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextEmail = findViewById(R.id.editTextEmail);
        contactos = findViewById(R.id.spinnerCont);


        comboContactos = (Spinner) findViewById(R.id.spinnerCont);
        listaNom = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();
        for(Persona persona : Memory.PERSONAS){
            nombres.add(persona.nombre);
            //nombres.add(persona.contactoConfianza);

        }
        //String[] nombre = new String[]{"juan","pedro","luis"};
        comboAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nombres);
        comboContactos.setAdapter(comboAdapter);

        comboContactos.setSelection(0);

        FloatingActionButton fabRegistrar = findViewById(R.id.fab_registrar);
        fabRegistrar.setOnClickListener(
                view->{
                    Persona persona = new Persona();
                    persona.nombre = editTextNombre.getText().toString();
                    persona.apellidoPaterno = editTextApellidoPaterno.getText().toString();
                    persona.apellidoMaterno = editTextApellidoMaterno.getText().toString();
                    persona.edad = Integer.parseInt(editTextEdad.getText().toString());
                    persona.telefono = editTextTelefono.getText().toString();
                    persona.email = editTextEmail.getText().toString();
                    if (comboAdapter.isEmpty())
                        persona.contactoConfianza = "";
                    else
                        persona.contactoConfianza = contactos.getSelectedItem().toString();



                    Memory.PERSONAS.add(persona);

                    finish();
                }

        );
    }
}

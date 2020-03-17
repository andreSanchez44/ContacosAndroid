package com.rockbass.contactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DetalleContactos extends AppCompatActivity {
    Spinner contConfianza;
    private RecyclerView cont;
    private EditText editTextNombre,editTextApellidoPaterno,editTextApellidoMaterno,editTextEdad,editTextTelefono,editTextEmail;
    Spinner contactos,comboContactos;
    List<String> listaNom;
    List<String> listaContactos;
    ArrayAdapter<String> comboAdapter;
    ArrayAdapter<String> contAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contactos);

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
    }/*
    @Override
    protected void onResume() {
        super.onResume();
        cont = (RecyclerView) findViewById(R.id.recyclerview_contactos);
        listaContactos = new ArrayList<>();
        ArrayList<String> contactos= new ArrayList<>();
        for (Persona personas : Memory.PERSONAS){

            contactos.add(personas.nombre);

        }

        /*contAdapter = new ArrayAdapter<String>(this,android.R.layout.activity_list_item);
        //cont.set

        RecyclerView recyclerView = findViewById(R.id.recyclerview_contactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        AdapterPersona adapterPersona = new AdapterPersona();

        adapterPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Seleccion: "+)

            }
        });

        recyclerView.setAdapter(adapterPersona);*/
    //}

    static class AdapterPersona extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements  View.OnClickListener{

        private View.OnClickListener listener;

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.activity_main, parent, false);

            return new RecyclerView.ViewHolder(view) {};
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            View view = holder.itemView;
            Persona persona = Memory.PERSONAS.get(position);

            TextView nombreCompleto, edad, telefono, email,contConfianza;

            nombreCompleto = view.findViewById(R.id.textViewNomCompleto);
            edad = view.findViewById(R.id.textViewEdad);
            telefono = view.findViewById(R.id.textViewTel);
            email = view.findViewById(R.id.textViewEmail);
            contConfianza = view.findViewById(R.id.spinnerCont);

            nombreCompleto.setText(
                    String.format("%s %s %s",
                            persona.nombre,
                            persona.apellidoPaterno,
                            persona.apellidoMaterno)
            );

            edad.setText(Integer.toString(persona.edad));
            telefono.setText(persona.telefono);
            email.setText(persona.email);
            contConfianza.setText("contacto de confianza: "+persona.contactoConfianza);
        }

        @Override
        public int getItemCount() {
            return Memory.PERSONAS.size();
        }
        public void setOnClickListener(View.OnClickListener listener){
            this.listener = listener;

        }

        public void onClick(View v) {
            if (listener!= null) {
                listener.onClick(v);


            }

        }


    }
}

package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int cont =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            cont++;
            Toast.makeText(MainActivity.this, "contador ="+(++cont), Toast.LENGTH_SHORT).show();

        }

    };
}

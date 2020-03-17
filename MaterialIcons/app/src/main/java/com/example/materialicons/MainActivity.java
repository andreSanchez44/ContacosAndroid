package com.example.materialicons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterIcon adapterIcon = new AdapterIcon();
    }

    private DataIcon[] generrateDatosIcons(){
        DataIcon dataIcon1 = new DataIcon();
        dataIcon1.idImage = R.drawable.ic_001_youtube;
    }

    class AdapterIcon extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private DataIcon[] dataIcons;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
    overrideget

    class DataIcon{
        public int idImage;
        public String nombre;
        public String descripcion;
    }
}


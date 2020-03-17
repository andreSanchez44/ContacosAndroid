package com.example.generadornumerosaleatorios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final NumberAdapter adapter = new NumberAdapter(generaraNumeroAleatorios());

        recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        adapter.notifyDataSetChanged();

        Button button = findViewById(R.id.button_generar);
        button.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                adapter.changeData(generaraNumeroAleatorios());
            }
        });
    }

    private int[] generaraNumeroAleatorios(){
        Random random = new Random();
        int cantidad = random.nextInt(2000)+50;
        int [] numeros = new int[cantidad];

        for (int index=0; index< cantidad; index++){
            numeros[index] = random.nextInt();
        }
        return numeros;
    }

    class NumberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private int [] numeros;

        public NumberAdapter(int[] numeros){
            this.numeros=numeros;
        }

        public void changeData(int[] numeros){
            this.numeros = numeros;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.text_number,parent,false);
            RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view) {

            };
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            TextView textView = (TextView)holder.itemView;
            int numero = numeros[position];

            textView.setText(Integer.toString(numero));

        }

        @Override
        public int getItemCount() {
            return numeros.length;
        }
    }
}

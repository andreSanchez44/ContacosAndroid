package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView log;
    private final static String TAG = "cicloDeVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = findViewById(R.id.log);
        log.append("onCreate llamado\n");
        Log.d(TAG, "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        log.append("onStart llamado\n");
        Log.d(TAG, "onStart llamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log.append("onDestroy llamado\n");
        Log.d(TAG, "onDestroy llamado");
    }

}

package com.example.javasquez.hilos_persistencia_sonido;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AyudaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
    }

    public void atras(View view){
        onBackPressed();
    }
}

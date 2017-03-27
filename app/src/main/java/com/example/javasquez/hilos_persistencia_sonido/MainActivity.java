package com.example.javasquez.hilos_persistencia_sonido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button easy = (Button) findViewById(R.id.facil);
        Button standard = (Button) findViewById(R.id.medio);
        final Button dificult = (Button) findViewById(R.id.dificil);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultad(v);
            }
        });
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultad(v);
            }
        });
        dificult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dificultad(v);
            }
        });
    }

    public void ayuda(View view) {
        Intent intent = new Intent(this, AyudaActivity.class);
        startActivity(intent);
    }

    public void dificultad(View vista) {
        String dific = (String) ((Button) vista).getText();
        Log.v("jvmjs", dific);
        Intent intent = new Intent(MainActivity.this, Gestion.class);
        Bundle bundle = new Bundle();
        int dificultad = 1;
        if (dific.equals("Normal")) dificultad = 2;
        if (dific.equals("Dificil")) dificultad = 3;
        Log.v("jvmjs", "Se envia el numemero: " + dificultad);
        bundle.putInt("DIFICULTAD", dificultad);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

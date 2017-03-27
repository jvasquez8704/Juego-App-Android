package com.example.javasquez.hilos_persistencia_sonido;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by javasquez on 27/03/2017.
 */

public class Gestion extends Activity {
    private Partida partida;
    private int dificultad;
    private int FPS = 30;//frames por segunto

    private Handler temporizador;// Manejador de hilo -> cada handler esta asociado con un unico hilo

    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        Bundle extras = getIntent().getExtras();
        dificultad = extras.getInt("DIFICULTAD");

        partida = new Partida(getApplicationContext(), dificultad);

        setContentView(partida);
    }

    private Runnable elHilo = new Runnable() {
        @Override
        public void run() {
            if (partida.movimientoBola()) fin();
            else {
                partida.invalidate();// elimina el contenido de ImageView, y llama onDraw
                temporizador.postDelayed(elHilo, 1000 / FPS);//Ponerle pausa al hilo
            }
        }
    };

    public boolean onTouchEvent(MotionEvent evento) {
        int x = (int) evento.getX();
        int y = (int) evento.getY();
        partida.toque(x, y);
        return false;// para salir de este metodo
    }

    public void fin() {
        temporizador.removeCallbacks(elHilo);
        finish();
    }
}

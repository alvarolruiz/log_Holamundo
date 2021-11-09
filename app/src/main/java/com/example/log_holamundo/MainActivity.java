package com.example.log_holamundo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String CONTADOR="";
    int contador;
    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt(CONTADOR);
        }
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.btn);
        tv = findViewById(R.id.cont);
        bt.setOnClickListener(this::OnClickSumador);
        Log.e("MainActivity", "Creando app");
    }

    private void OnClickSumador(View view) {
        contador++;
        Toast.makeText(this, "Has sumado 1 al contador", Toast.LENGTH_SHORT);
        Log.e("MainActivity", "Click en boton. Contador = " + contador);
        tv.setText(String.valueOf(contador));

    }

    @Override
    protected void onStart() {
        Log.i("MainActivity", "on start ejecutado");
        Log.e("Estado contador start", "contador=" + contador);
        super.onStart();


    }

    @Override
    protected void onResume() {
        /*
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        */
        Log.w("MyActivity", "On resume ejecutado");
        Log.e("Estado contador resume", "contador=" + contador);
        super.onResume();
     }

    protected void onPause() {
        Log.w("MyActivity", "Entrando en estado de pausa");
        Log.e("Estado contador pause", "contador=" + contador);
        super.onPause();


    }

    protected void onStop() {
        Log.e("My Activity", "onStop: ejecutado");
        Log.e("Estado contador stop", "contador=" + contador);
        super.onStop();


    }

    protected void onDestroy() {
        Log.e("MyActivity", "onDestroy ejecutado");
        Log.e("Estado contador", "contador=" + contador);
         super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CONTADOR, contador);
        Log.e("Main Activity", "se ha guardado el valor de contador. Cont="+contador );
        super.onSaveInstanceState(outState);

    }


}
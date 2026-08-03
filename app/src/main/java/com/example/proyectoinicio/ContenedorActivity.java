package com.example.proyectoinicio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContenedorActivity extends AppCompatActivity {

    TextView hola;
    TextView adios;
    TextView gracias;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        hola = findViewById(R.id.textView);
        adios = findViewById(R.id.textView2);
        gracias = findViewById(R.id.textView3);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            String hola2 = bundle.getString("first2");
            hola.setText(hola2);

            Float adios2 = bundle.getFloat("first3");
            adios.setText(String.valueOf(adios2));

            Character gracias2 = bundle.getChar("first4");
            gracias.setText(String.valueOf(gracias2));
        }
    }
}
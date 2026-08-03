package com.example.proyectoinicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartActivity extends AppCompatActivity {


    ImageView Logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Logo = findViewById(R.id.imgLogo);

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "Hola, ¿Cómo fue tu día?";
                Intent intent1 = new Intent(StartActivity.this, WelcomeActivity.class);
                intent1.putExtra("messageUser", mensaje);
                startActivity(intent1);
            }
        });
    }
}
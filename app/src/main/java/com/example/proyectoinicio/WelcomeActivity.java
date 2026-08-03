package com.example.proyectoinicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    Button google;
    Button facebook;
    TextView account;
    TextView entry;
    TextView well;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        google = findViewById(R.id.btnGoogle);
        facebook = findViewById(R.id.btnFacebook);
        account = findViewById(R.id.txtCuenta);
        entry = findViewById(R.id.txtRegistrar);

        well = findViewById(R.id.txtSend);
        String messageSend = getIntent().getStringExtra("messageUser");
        well.setText(messageSend);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(first);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(second);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent third = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(third);
            }
        });
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fourth = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(fourth);
            }
        });
    }
}
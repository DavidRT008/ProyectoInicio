package com.example.proyectoinicio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TunelActivity extends AppCompatActivity {

    Button Send;
    EditText Hello;
    EditText Bye;
    EditText Thank;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tunel);

        Send = findViewById(R.id.btnSend);
        Hello = findViewById(R.id.editTextText1);
        Bye = findViewById(R.id.editTextText2);
        Thank = findViewById(R.id.editTextText3);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(TunelActivity.this, ContenedorActivity.class);

                Bundle first1 = new Bundle();
                first1.putString("first2", Hello.getText().toString());
                first.putExtras(first1);

                Bundle first2 = new Bundle();
                first2.putFloat("first3", Float.parseFloat(Bye.getText().toString()));
                first.putExtras(first2);

                Bundle first3 = new Bundle();
                first3.putChar("first4", Thank.getText().toString().charAt(0));
                first.putExtras(first3);

                startActivity(first);
            }
        });
    }
}
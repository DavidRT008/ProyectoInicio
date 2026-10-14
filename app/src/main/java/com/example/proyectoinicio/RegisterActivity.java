package com.example.proyectoinicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    Button google;
    Button facebook;
    Button register;
    EditText mail;
    EditText password;
    DBMotor dbmotor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        google = findViewById(R.id.btnGoogle);
        facebook = findViewById(R.id.btnFacebook);
        register = findViewById(R.id.btnSesion);
        mail = findViewById(R.id.editCorreo);
        password = findViewById(R.id.editContraseña);
        dbmotor = new DBMotor(this);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(first);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(second);
            }
        });

        /*register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent third = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(third);
            }
        });
        register.setOnClickListener(v -> {

            String correo = mail.getText().toString();
            String contraseña = password.getText().toString();

            User user = new User(correo, contraseña);

            Data.Users.add(user);
        });*/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = mail.getText().toString().trim();
                String contraseña = password.getText().toString().trim();

                if(correo.isEmpty() || contraseña.isEmpty()){
                    mail.setError("Ingrese el correo");
                    password.setError("Ingrese la contraseña");
                    return;
                }

                User user = new User(correo, contraseña);

                if (!dbmotor.insertarUsuario(user)) {
                    mail.setError("El correo ya está registrado");
                    return;
                }

                Toast.makeText(
                        RegisterActivity.this,
                        "Usuarios registrados: " + dbmotor.contarUsuarios(),
                        Toast.LENGTH_SHORT
                ).show();

                Intent third = new Intent(RegisterActivity.this, UserActivity.class);
                startActivity(third);
            }
        });
    }

    @Override
    protected void onDestroy() {
        dbmotor.close();
        super.onDestroy();
    }
}

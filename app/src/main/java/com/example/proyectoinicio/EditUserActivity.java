package com.example.proyectoinicio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserActivity extends AppCompatActivity {

    EditText editCorreo, editPassword;
    Button btnGuardar;

    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        editCorreo = findViewById(R.id.editCorreo);
        editPassword = findViewById(R.id.editPassword);
        btnGuardar = findViewById(R.id.btnGuardar);

        posicion = getIntent().getIntExtra("posicion", -1);

        if (posicion != -1) {

            User usuario = Data.Users.get(posicion);

            editCorreo.setText(usuario.getMail());
            editPassword.setText(usuario.getPassword());

        }

        btnGuardar.setOnClickListener(v -> {

            String correo = editCorreo.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if(correo.isEmpty() || password.isEmpty()){

                Toast.makeText(this,
                        "Complete todos los campos",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            User usuario = Data.Users.get(posicion);

            usuario.setMail(correo);
            usuario.setPassword(password);

            Toast.makeText(this,
                    "Usuario actualizado",
                    Toast.LENGTH_SHORT).show();

            finish();

        });

    }

}
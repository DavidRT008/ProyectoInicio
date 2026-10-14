package com.example.proyectoinicio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserActivity extends AppCompatActivity {

    public static final String EXTRA_USUARIO_ID = "usuario_id";

    EditText editCorreo, editPassword;
    Button btnGuardar;

    DBMotor dbmotor;
    User usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        editCorreo = findViewById(R.id.editCorreo);
        editPassword = findViewById(R.id.editPassword);
        btnGuardar = findViewById(R.id.btnGuardar);
        dbmotor = new DBMotor(this);

        long usuarioId = getIntent().getLongExtra(EXTRA_USUARIO_ID, -1);
        usuario = dbmotor.obtenerUsuario(usuarioId);

        if (usuario != null) {
            editCorreo.setText(usuario.getMail());
            editPassword.setText(usuario.getPassword());
        } else {
            Toast.makeText(this,
                    "No se encontró el usuario",
                    Toast.LENGTH_SHORT).show();
            finish();
            return;
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

            usuario.setMail(correo);
            usuario.setPassword(password);

            if (dbmotor.actualizarUsuario(usuario)) {
                Toast.makeText(this,
                        "Usuario actualizado",
                        Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this,
                        "No se pudo actualizar. Verifique el correo",
                        Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    protected void onDestroy() {
        dbmotor.close();
        super.onDestroy();
    }

}

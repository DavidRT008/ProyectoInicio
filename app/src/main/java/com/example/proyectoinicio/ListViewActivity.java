package com.example.proyectoinicio;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView listViewUsuarios;
    private TextView tvMenuPrincipal;

    ArrayList<String> nombres = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Lista de usuarios (POO)
        ArrayList<Usuario> usuarios = new ArrayList<>();
        boolean carlos = usuarios.add(new Usuario("Carlos", "12345", "carlos@gmail.com"));
        usuarios.add(new Usuario("Karla", "234", "karla@gmail.com"));
        usuarios.add(new Usuario("Marta", "987", "marta@gmail.com"));

        // Vincular vistas
        listViewUsuarios = findViewById(R.id.listUsers);

        // Configurar adaptador personalizado
        /*UsuarioAdapterListView adapter = new UsuarioAdapterListView(this);
        listViewUsuarios.setAdapter(adapter);*/
    }
}
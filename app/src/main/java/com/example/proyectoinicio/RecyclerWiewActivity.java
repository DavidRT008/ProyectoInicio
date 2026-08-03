/*package com.example.proyectoinicio;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerWiewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> listaUsuarios;
    private List<Usuario> listaUsuarios2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_wiew);

        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("David", "Rodriguez"));
        listaUsuarios.add(new Usuario("Daniel", "Noboa"));
        listaUsuarios.add(new Usuario("Dania","Viri"));
        listaUsuarios.add(new Usuario("Dionisio","Castro"));
        listaUsuarios.add(new Usuario("Damaris","Camil"));
        listaUsuarios.add(new Usuario("Duncan","Perez"));

        listaUsuarios2 = new ArrayList<>();
        listaUsuarios2.add(new Usuario("David", "Rodriguez", 27, "f"));
        listaUsuarios2.add(new Usuario("Daniel", "Noboa", 25, "f"));
        listaUsuarios2.add(new Usuario("Dania", "Viri", 19, "f"));
        listaUsuarios2.add(new Usuario("Dionisio", "Castro", 45, "f"));
        listaUsuarios2.add(new Usuario("Damaris", "Camil", 18, "f"));
        listaUsuarios2.add(new Usuario("Duncan", "Perez", 20, "f"));

        UsuarioAdapter usuarioadapter = new UsuarioAdapter(listaUsuarios2, this, new UsuarioAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(Usuario item) {
                moveToDescription(item);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usuarioAdapter = new UsuarioAdapter(listaUsuarios);
        recyclerView.setAdapter(usuarioAdapter);
    }

    public void moveToDescription(Usuario item) {
        Intent intent = new Intent(RecyclerWiewActivity.this, DecriptionActivity.class);
        intent.putExtra("Usuario", item);
        startActivity(intent);
    }
}*/
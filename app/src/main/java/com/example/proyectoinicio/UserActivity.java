package com.example.proyectoinicio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private DBMotor dbmotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = findViewById(R.id.recyclerUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbmotor = new DBMotor(this);
        adapter = new UserAdapter(this, Data.Users);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        cargarUsuarios();
    }

    private void cargarUsuarios() {
        Data.Users.clear();
        Data.Users.addAll(dbmotor.obtenerUsuarios());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        dbmotor.close();
        super.onDestroy();
    }
}

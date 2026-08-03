package com.example.proyectoinicio;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private ArrayList<User> listaUsuarios;

    public UserAdapter(Context context, ArrayList<User> listaUsuarios) {
        this.context = context;
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User usuario = listaUsuarios.get(position);

        holder.txtCorreo.setText(usuario.getMail());
        holder.txtPassword.setText(usuario.getPassword());

        //Eliminar
        holder.btnEliminar.setOnClickListener(v -> {

            new AlertDialog.Builder(context)
                    .setTitle("Eliminar")
                    .setMessage("¿Desea eliminar este usuario?")
                    .setPositiveButton("Sí", (dialog, which) -> {

                        int pos = holder.getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            listaUsuarios.remove(pos);
                            notifyItemRemoved(pos);
                            notifyItemRangeChanged(pos, listaUsuarios.size());
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        });

        //Editar
        holder.btnEditar.setOnClickListener(v -> {

            int pos = holder.getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                Intent intent = new Intent(context, EditUserActivity.class);
                intent.putExtra("posicion", pos);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCorreo;
        TextView txtPassword;

        Button btnEditar;
        Button btnEliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCorreo = itemView.findViewById(R.id.txtCorreo);
            txtPassword = itemView.findViewById(R.id.txtPassword);

            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}

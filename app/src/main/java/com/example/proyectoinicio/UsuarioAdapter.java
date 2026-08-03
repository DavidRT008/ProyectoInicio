/*package com.example.proyectoinicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter <UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> listaUsuarios;

    public UsuarioAdapter(List<Usuario> listaUsuarios, UsuarioAdapter.OnItemClickListener listener) {
        this.listaUsuarios = listaUsuarios;
        this.listener = listener;
    }

    final UsuarioAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Usuario item);
    }

    @NonNull
    @Override
    public UsuarioAdapter.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.bind(usuario);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView;
        private TextView edadTextView;
        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            edadTextView = itemView.findViewById(R.id.edadTextView);
        }
        public void bind(Usuario usuario) {
            nombreTextView.setText(usuario.getNombre());
            edadTextView.setText(String.valueOf(usuario.getEdad()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(usuario);
                }
            });
        }

    }
}*/

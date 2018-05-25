package com.example.marcos.bolaocopadomundo.control;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marcos.bolaocopadomundo.R;
import com.example.marcos.bolaocopadomundo.model.Usuario;

import java.util.List;

public class AdapterRanking extends RecyclerView.Adapter<AdapterRanking.ViewHolder> {

    private List<Usuario> usuarios;

    public AdapterRanking(List<Usuario> usuarios) {
        this.usuarios = usuarios;

    }

    @NonNull
    @Override
    public AdapterRanking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.adapter_list_ranking, parent, false);
        AdapterRanking.ViewHolder vh = new AdapterRanking.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRanking.ViewHolder holder, int position) {
        final Usuario usuario = usuarios.get(position);

        holder.tvNome.setText(usuario.getNome());
        holder.tvPontuacao.setText(String.valueOf(usuario.getPontuacao()));
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public List<Usuario> tabelaAtualizada(){
        return usuarios;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNome;
        private TextView tvPontuacao;

        public ViewHolder(View v) {
            super(v);

            tvNome = (TextView) v.findViewById(R.id.tv_nome_ranking);
            tvPontuacao = (TextView) v.findViewById(R.id.tv_pontuacao_ranking);
        }

    }
}


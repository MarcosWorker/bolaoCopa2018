package com.example.marcos.bolaocopadomundo.control;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcos.bolaocopadomundo.R;
import com.example.marcos.bolaocopadomundo.model.Jogo;

import java.util.List;

public class AdapterTabela extends RecyclerView.Adapter<AdapterTabela.ViewHolder> {

    private List<Jogo> jogos;

    public AdapterTabela(List<Jogo> jogos) {
        this.jogos = jogos;

    }

    @NonNull
    @Override
    public AdapterTabela.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.adapter_list_tabela, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTabela.ViewHolder holder, int position) {
        final Jogo jogo = jogos.get(position);

        //logo time 1
        holder.imgTime1.setImageResource(jogo.getImgTime1());
        //nome time 1
        holder.tvTime1.setText(jogo.getTime1());
        //placar time 1
        holder.edtPlacarTime1.setText(String.valueOf(jogo.getPlacarTime1()));
        //logo time 2
        holder.imgTime2.setImageResource(jogo.getImgTime2());
        //nome time 2
        holder.tvTime2.setText(jogo.getTime2());
        //placar time 2
        holder.edtPlacarTime2.setText(String.valueOf(jogo.getPlacarTime2()));
        //placar real
        holder.tvPlacarReal.setText(jogo.getPlacarTime1()+" x "+jogo.getPlacarTime2());

    }

    @Override
    public int getItemCount() {
        return jogos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTime1;
        private TextView tvTime1;
        private EditText edtPlacarTime1;
        private ImageView imgTime2;
        private TextView tvTime2;
        private EditText edtPlacarTime2;
        private TextView tvPlacarReal;


        public ViewHolder(View v) {
            super(v);

            imgTime1 = (ImageView)v.findViewById(R.id.imgtime1);
            tvTime1 = (TextView) v.findViewById(R.id.tv_time1);
            edtPlacarTime1 = (EditText) v.findViewById(R.id.edit_placar_time1);
            imgTime2 = (ImageView)v.findViewById(R.id.imgtime2);
            tvTime2 = (TextView) v.findViewById(R.id.tv_time2);
            edtPlacarTime2 = (EditText) v.findViewById(R.id.edit_placar_time2);
            tvPlacarReal = (TextView) v.findViewById(R.id.tv_placar_real);
        }

    }
}

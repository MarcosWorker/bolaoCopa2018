package com.example.marcos.bolaocopadomundo.view;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.marcos.bolaocopadomundo.R;
import com.example.marcos.bolaocopadomundo.control.AdapterTabela;
import com.example.marcos.bolaocopadomundo.model.Jogo;
import com.example.marcos.bolaocopadomundo.util.Util;

import java.util.ArrayList;
import java.util.List;

public class TabelaActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager mLayoutManager = null;
    private AdapterTabela adapterTabela = null;
    private List<Jogo> jogos;
    private Util util;
    private AlertDialog alerta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);

        util = new Util();

        jogos = util.TabelaPrimeiraFase();

        recyclerView = (RecyclerView) findViewById(R.id.rv_tabela);

        adapterTabela = new AdapterTabela(jogos);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterTabela);
    }

    @Override
    public void onBackPressed() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("ATENÇÃO!");
        //define a mensagem
        builder.setMessage("Todos os dados alterados serão perdidos");
        //define um botão como positivo
        builder.setPositiveButton("OK, entendi", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
}

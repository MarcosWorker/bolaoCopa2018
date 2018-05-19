package com.example.marcos.bolaocopadomundo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        super.onBackPressed();
        finish();
    }
}

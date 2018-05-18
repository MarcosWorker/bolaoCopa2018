package br.com.app.vitaervasapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.app.vitaervasapp.R;
import br.com.app.vitaervasapp.control.adapters.AdapterItens;
import br.com.app.vitaervasapp.control.adapters.AdapterMenuItens;
import br.com.app.vitaervasapp.model.Produto;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMenu;
    private RecyclerView recyclerViewItens;
    private AdapterMenuItens adapterMenuItens;
    private AdapterItens adapterItens;
    private RecyclerView.LayoutManager mLayoutManagerMenu;
    private RecyclerView.LayoutManager mLayoutManagerItens;
    private List<String> itensMenu;
    private List<Produto> produtos;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itensMenu = new ArrayList<>();
        //preencher lista do menu de itens
        itensMenu.add("Promoções");
        itensMenu.add("Albuminas");
        itensMenu.add("Alimentos / Bebidas");
        itensMenu.add("BCAA");
        itensMenu.add("Cosméticos");
        itensMenu.add("Carboidratos");
        itensMenu.add("Glutamina");
        itensMenu.add("Creatina");
        itensMenu.add("Naturais");
        itensMenu.add("Termogênicos");
        itensMenu.add("Packs");
        itensMenu.add("Pré-Treinos");
        itensMenu.add("Proteínas");

        //exibe a lista do menu na tela
        adapterMenuItens = new AdapterMenuItens(itensMenu);
        recyclerViewMenu = (RecyclerView) findViewById(R.id.rv_bar);
        mLayoutManagerMenu = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMenu.setLayoutManager(mLayoutManagerMenu);
        recyclerViewMenu.setAdapter(adapterMenuItens);

        //Preenche lista inicial de itens
        produtos = new ArrayList<>();
        //int id, String nome, String desc, double preco, int div, int img, int status
        produto = new Produto(0,
                "Albumix Plus Integral Medica 1kg",
                "Descrição do Albumix",
                95.50,
                10,
                R.mipmap.ic_albumix_plus_integralmedica_1kg,
                0);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        produtos.add(produto);
        //exibe lista de itens na tela
        adapterItens = new AdapterItens(produtos);
        recyclerViewItens = (RecyclerView) findViewById(R.id.rv_itens);
        mLayoutManagerItens = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewItens.setLayoutManager(mLayoutManagerItens);
        recyclerViewItens.setAdapter(adapterItens);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_loja:
                Toast.makeText(this, "Tela de loja", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_receitas:
                Toast.makeText(this, "Tela de receitas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_eventos:
                Toast.makeText(this, "Tela de eventos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_promocoes:
                Toast.makeText(this, "Tela de promoções", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_parceiros:
                Toast.makeText(this, "Tela de parceiros", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_contato:
                Toast.makeText(this, "Tela de contatos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_sair:
                Toast.makeText(this, "Tela de sair", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;
    }
}

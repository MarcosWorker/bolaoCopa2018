package com.example.marcos.bolaocopadomundo.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marcos.bolaocopadomundo.R;
import com.example.marcos.bolaocopadomundo.control.AdapterAtualizar;
import com.example.marcos.bolaocopadomundo.model.Jogo;
import com.example.marcos.bolaocopadomundo.model.Usuario;
import com.example.marcos.bolaocopadomundo.util.Util;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class AtualizarActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager mLayoutManager = null;
    private AdapterAtualizar adapterAtualizar = null;
    private List<Jogo> jogos;
    private AlertDialog alerta;
    private DatabaseReference mDatabase;
    private FirebaseUser user;
    private Button btAtualizarTabela;
    private Usuario usuario;
    private int master = 0;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        //ver se usuario esta logado
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            Intent intent = new Intent(AtualizarActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        //pegar referencia do objeto usuario no firebase database
        mDatabase = FirebaseDatabase.getInstance().getReference("usuario");

        //botão salvar

        btAtualizarTabela = findViewById(R.id.bt_salvar_tabela);
        btAtualizarTabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarTabela();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    usuario = dataSnapshot.getValue(Usuario.class);

                    if(usuario.getUid().equals("uidmaster")){
                        jogos = usuario.getJogos();
                        montarTabela();
                        master = 1;
                    }else {
                        usuario = null;
                    }
                }

                if(master == 0){

                    //gerar primary key
                    String id = mDatabase.push().getKey();

                    usuario = new Usuario();
                    util = new Util();
                    usuario.setJogos(util.TabelaPrimeiraFase());
                    usuario.setNome("tabela master");
                    usuario.setId("id");
                    usuario.setEmail("master@gmail.com");
                    usuario.setPontuacao(0);
                    usuario.setUid("uidmaster");

                    // salvar no database
                    mDatabase.child(id).setValue(usuario);
                    // preenche tabela vazia
                    jogos = usuario.getJogos();
                    montarTabela();

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AtualizarActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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

    private void montarTabela(){
        recyclerView = (RecyclerView) findViewById(R.id.rv_tabela_atualizar);
        adapterAtualizar = new AdapterAtualizar(jogos);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterAtualizar);
    }

    private void atualizarTabela(){
        //verificar se pode alterar

        //salvar tabela
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                mDatabase.child(usuario.getId()).setValue(usuario);
                Toast.makeText(AtualizarActivity.this, "Tabela atualizada com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AtualizarActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

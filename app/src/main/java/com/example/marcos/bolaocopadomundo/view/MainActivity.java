package com.example.marcos.bolaocopadomundo.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcos.bolaocopadomundo.R;
import com.example.marcos.bolaocopadomundo.model.Jogo;
import com.example.marcos.bolaocopadomundo.model.Usuario;
import com.example.marcos.bolaocopadomundo.util.Util;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button signOutButton;
    private Button btTabela;
    private Button btRanking;
    private Button btAtualizar;
    private FirebaseUser user;
    private TextView tvBoasVIndas;
    private DatabaseReference mDatabase;
    private Util util;
    private Usuario usuario;
    private int usuarioCadastrado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //buttom

        signOutButton = findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btTabela = findViewById(R.id.tabela);
        btTabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabelaActivity.class);
                startActivity(intent);
            }
        });

        btAtualizar = findViewById(R.id.atualizar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AtualizarActivity.class);
                startActivity(intent);
            }
        });

        btRanking = findViewById(R.id.ranking);
        btRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RankingActivity.class);
                startActivity(intent);
            }
        });

        //ver se o usuário ta logado
        user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null){
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }else{
            //texto do usuario
            tvBoasVIndas = (TextView)findViewById(R.id.tv_boas_vindas);
            if(user.getEmail().equals("tagsudra86@gmail.com")){
                tvBoasVIndas.setText(user.getDisplayName()+" você está logado como Administrador");
            }else{
                tvBoasVIndas.setText(user.getDisplayName()+" você está logado como Participante");
            }

            //pegar referencia do objeto usuario no firebase database
            mDatabase = FirebaseDatabase.getInstance().getReference("usuario");
            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        usuario = dataSnapshot.getValue(Usuario.class);
                        if(usuario.getUid().equals(user.getUid())){
                            usuarioCadastrado = 1;
                        }
                    }

                    if(usuarioCadastrado == 0){
                        usuario = new Usuario();
                        //gerar primary key
                        String id = mDatabase.push().getKey();

                        util = new Util();
                        usuario.setId(id);
                        usuario.setJogos(util.TabelaPrimeiraFase());
                        usuario.setEmail(user.getEmail());
                        usuario.setUid(user.getUid());
                        usuario.setNome(user.getDisplayName());
                        usuario.setPontuacao(0);
                        // salvar no database
                        mDatabase.child(id).setValue(usuario);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}


package com.example.marcos.bolaocopadomundo.util;

import com.example.marcos.bolaocopadomundo.R;
import com.example.marcos.bolaocopadomundo.model.Jogo;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public Util() {
    }

    public List<Jogo>TabelaPrimeiraFase(){
        List<Jogo> jogos = new ArrayList<>();

        jogos.add(new Jogo("Rússia",
                0,
                R.drawable.russia_round_icon_64,
                "Arábia-Saudita",
                0,
                R.drawable.saudi_arabia_round_icon_64,
                "rodada 1",
                "fase 1",
                0,
                "Qui 14/06/2018",
                "12:00"));
        jogos.add(new Jogo("Egito",
                0,
                R.drawable.egypt_round_icon_64,
                "Uruguai",
                0,
                R.drawable.uruguay_round_icon_64,
                "rodada 1",
                "fase 1",
                0,
                "Sex 15/06/2018",
                "09:00"));
        jogos.add(new Jogo("Marrocos",
                0,
                R.drawable.morocco_round_icon_64,
                "Irã",
                0,
                R.drawable.iran_round_icon_64,
                "rodada 1",
                "fase 1",
                0,
                "Sex 15/06/2018",
                "12:00"));
        jogos.add(new Jogo("Portugal",
                0,
                R.drawable.portugal_round_icon_64,
                "Espanha",
                0,
                R.drawable.spain_round_icon_64,
                "rodada 1",
                "fase 1",
                0,
                "Sex 15/06/2018",
                "15:00"));

        return jogos;
    }
}

package com.rpg.combate;


import Personagens.Combatente;
import Personagens.Heroi;
import Personagens.Herois.Arqueira; // Importamos a Arqueira especificamente

public class FlechaPerfurante implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " atacou com: Flecha Perfurante!");

        int dano;
        // Precisamos que o usuario seja uma Arqueira para usar a 'precisao'
        if (usuario instanceof Arqueira) {
            Arqueira arqueira = (Arqueira) usuario;

            if ((arqueira.getSorte() + arqueira.precisao) >= 0.7f) {
                dano = (int) (arqueira.getDano() * 1.3f);
                System.out.println(arqueira.getNome() + " acertou um golpe preciso e causou mais dano!");
            } else {
                dano = arqueira.getDano(); // Usamos getDano() para incluir a arma
            }
            alvo.receberDano(dano);
        }
    }
}
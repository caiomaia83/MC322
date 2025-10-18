package com.rpg.game.personagens.Monstros; // Seu pacote

import java.util.List;
// O import do ArrayList e AtaqueFisico não são mais necessários aqui dentro
// import java.util.ArrayList;
// import com.rpg.combate.*;

// Seus imports originais (mantidos)
import com.rpg.itens.Arma;
import com.rpg.itens.classificadores.OrigemDoItem;
import com.rpg.itens.loot.ConstrutorDeTabelaDeLoot;
import com.rpg.itens.loot.GerenciadorDeLoot;
import com.rpg.personagens.Monstro;


public class Esqueleto extends Monstro {
    
    static List<Arma> LISTA_DE_ARMAS = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(OrigemDoItem.ESQUELETO);

    public Esqueleto(int pontosDeVida, int forca, int xpconcedido) {
        super("Esqueleto", OrigemDoItem.ESQUELETO, pontosDeVida, forca, xpconcedido, (Arma) GerenciadorDeLoot.sortearItem(LISTA_DE_ARMAS));
        // O construtor NÃO define mais as ações aqui. O ConstrutorDeCenario fará isso.
    }

    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        // Calcula os novos atributos (sua lógica original está correta)
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);

        // Cria a nova instância fortalecida
        Esqueleto copia = new Esqueleto(novaVida, novaForca, novoXp);
        
        copia.setAcoes(this.acoes); 
        // ---------------------------------
        

        return copia; // Retorna a cópia fortalecida e com as ações corretas
    }
}
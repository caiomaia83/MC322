package com.rpg.game.itens.Armas.ArmasHerois.RecrutasReais;

import com.rpg.game.itens.Armas.ArmasBase.*;
import com.rpg.game.itens.Classificadores.*;

// Primeira lança desbloqueada por um recruta real
public class LancaDeTreinamento extends Lanca {
    
    public LancaDeTreinamento(){
        super("Lança de Treinamento", Raridade.COMUM, OrigemDoItem.GERAL, 1, 8, 0.15f);

        String desc = """
                A primeira arma que todo recruta recebe. 
                Sua ponta foi levemente arredondada para evitar acidentes fatais durante os treinos. 
                A madeira de freixo é lisa e polida pelas mãos de incontáveis soldados que aprenderam com ela a importância da formação, 
                do alcance e da disciplina. Cheira a suor e determinação.
                """;
        this.setDescricao(desc);
    
    }

}

package com.rpg.itens.Armas.ArmasMonstros.Esqueletos.Comum;

import com.rpg.itens.Armas.ArmasBase.Adaga;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class LascaDeOsso extends Adaga{
    public LascaDeOsso () {
        super("Lâmina Cerimonial de Tumba", Raridade.COMUM, OrigemDoItem.ESQUELETO, 1, 3, 0.3f);

        String desc= """
                A ferramenta mais básica de um morto-vivo sem recursos. É um fragmento de fêmur 
                ou de outra parte esquelética, quebrado e afiado contra as pedras da própria cripta. 
                É quebradiça e irregular, mas pontuda o suficiente para encontrar uma brecha entre as costelas
                """;
        this.setDescricao(desc);
    }
    
}

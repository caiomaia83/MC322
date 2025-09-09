package Itens.Armas.Monstros.Esqueletos.Lendario;


import Itens.Armas.ArmasBase.Arco;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;


// TO DO: Adicionar atributo especial 
public class VisaoDoCeifador extends Arco{
    public VisaoDoCeifador() {
        super("Visao do Ceifador", Raridade.LENDARIO, OrigemDoItem.ESQUELETO, 30, 50, 0.55f);
        String desc = """
                Forjado com o osso de um titã e o olho da Morte. Não mire no corpo; mire no destino. 
                A flecha não voa, ela cumpre
                """;
        this.setDescricao(desc);

    }
}

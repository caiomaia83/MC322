package Itens.Armas.Herois.RecrutasReais;
import Itens.Armas.ArmasBase.Lanca;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

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

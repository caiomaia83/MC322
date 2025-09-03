package Armas.Monstros.Corredor;

import Armas.ArmasBase.Martelo;
import Classificadores.Raridade;

public class DemolidorDeTorres extends Martelo{
    public DemolidorDeTorres() {
        super("Demolidor de Torres", 12, 45, 8);
        this.setRaridade(Raridade.EPICO);
        String desc = """
                Um martelo pesado e funcional, com a cabeça quadrada e maciça. 
                Foi projetado com um único propósito: quebrar o que não deveria ser quebrado. 
                É especialmente eficaz contra escudos, portões e construções. O cabo de madeira é reforçado com anéis de ferro, 
                garantindo que a arma não se despedace antes de seu alvo.
                """;
        this.setDescricao(desc);
    }
}

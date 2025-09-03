package Armas.Monstros.Esqueletos.Incomum;

import Armas.ArmasBase.Espada;
import Classificadores.Raridade;

public class AlfangeDoFosso extends Espada{
    private boolean ferrugem; // Atributo único dessa lâmina

    public AlfangeDoFosso() {
        super("Alfange do Fosso", 1,12, 1);
        this.setRaridade(Raridade.INCOMUM);
        String desc= """
                Esta espada passou décadas, talvez séculos, submersa na lama e na água parada de um fosso ou esgoto de masmorra. 
                A lâmina está coberta por uma camada espessa e escura de corrosão e lodo endurecido.
                Cheira a mofo e decomposição, e o cabo de couro está escorregadio e inchado pela umidade.
            """;
                    
        this.setDescricao(desc);
        this.ferrugem = true;
    }

    public boolean temFerrugem() { // TO DO: implementar lógica de efeitos no ataque
        return this.ferrugem;
    }
}

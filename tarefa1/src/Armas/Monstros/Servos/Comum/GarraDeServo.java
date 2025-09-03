package Armas.Monstros.Servos.Comum;

import Armas.ArmasBase.Adaga;
import Classificadores.Raridade;

public class GarraDeServo extends Adaga{
    public GarraDeServo() {
        super("Garra de Servo", 1, 6, 4);
        this.setRaridade(Raridade.COMUM);
        String desc = """
                A garra afiada de um servo menor, arrancada após sua destruição. 
                É leve, serrilhada e surpreendentemente dura, mas o cabo improvisado com tiras de couro dificulta o manuseio. 
                Mantém um leve cheiro de elixir negro.
                """;
        this.setDescricao(desc);
    }
}

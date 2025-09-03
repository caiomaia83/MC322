package Armas.Monstros.Servos.Incomum;

import Armas.ArmasBase.Adaga;
import Classificadores.Raridade;

public class FerraoDeServo extends Adaga{
    public FerraoDeServo() {
        super("Ferrão de Servo Maior", 4, 14, 6);
        this.setRaridade(Raridade.INCOMUM);
        String desc = """
                O ferrão de um Servo Maior, notavelmente mais denso e afiado que uma garra comum. 
                Sua ponta é perfeita para encontrar e penetrar as junções de armaduras. 
                A arma parece ter uma predileção por alvos bem protegidos.
                """;
        this.setDescricao(desc);
    }
}

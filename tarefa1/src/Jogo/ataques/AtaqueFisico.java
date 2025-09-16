package Jogo.ataques;
import Jogo.ataques.AcaoCombate;
import Personagens.Personagem;
import Personagens.Combatente;

public class AtaqueFisico implements AcaoCombate{
    
@Override
public void executar(Combatente usuario, Combatente alvo) {
        
        System.out.println(usuario.getNome() + " usa um Ataque Físico!");

        int danoTotal = 0;
        // Verificamos se quem está atacando é um "Personagem"
 
        if (usuario instanceof Personagem) {
            Personagem personagemUsuario = (Personagem) usuario;
            
            // Aqui usamos aquele método getDano() que você já tinha em Personagem!
            // Ele já calcula a força + o dano da arma. Perfeito!
            danoTotal = personagemUsuario.getDano();
        }

        if (danoTotal <= 0) {
            // Garante que o ataque sempre cause pelo menos 1 de dano para dar feedback
            danoTotal = 1;
        }

        // Finalmente, a ação diz para o alvo receber o dano calculado
        alvo.receberDano(danoTotal);
    }
}
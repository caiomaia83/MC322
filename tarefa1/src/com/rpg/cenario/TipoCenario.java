package com.rpg.cenario;

import java.util.ArrayList;
import java.util.List;

import Personagens.Heroi;
import Personagens.Monstro;
import Personagens.Monstros.Corredor;
import Personagens.Monstros.Esqueleto;
import Personagens.Monstros.Servo;

public enum TipoCenario {


    Tigela_Bárbara("Uma arena simples e rústica onde força é tudo o que importa."){
        @Override
        public void aplicarEfeitos(Heroi heroi){
        System.out.println("O grito estridente dos bárbaros ecoa, aumentando o dano de ataque de " + heroi.getNome() + " em 5 pontos!");
        //heroi.aumentarDano(5);
        }
    },
                
    Vale_dos_Feitiços("Um vale misterioso onde a magina predomina") {
        @Override 
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("A energia mágica do vale revigora " + heroi.getNome() + ", restaurando 10 pontos de vida!");
            heroi.receberCura(10);
        }

    },

    Oficina_do_Construtor("Um local repleto de engenhocas e armadilhas") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("As engenhocas da arena são genialmente usadas por " + heroi.getNome() + ", aumentando sua defesa em 3 pontos!");
           // heroi.aumentarDefesa(3);
        }
    },
                
    Teatro_da_Pekka("A arena é um palco grandioso onde batalhas épicas são encenadas") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("A presença imponente de " + heroi.getNome() + " inspira coragem, aumentando sua chance de crítico em 5%!");
            //heroi.aumentarChanceCritico(5);
        }
    },
                
    Arena_Real("Nessa arena acontecem batalhas classicas onde ningeuem leva vantagem") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println(heroi.getNome() + " sente-se equilibrado e focado, sem efeitos adicionais nesta arena.");
        }
    },
                
    Pico_Congelado("Um pico gelado onde o frio é um inimigo constante") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("O frio cortante do pico enfraquece " + heroi.getNome());
            //
        }
    },
                
    Arena_de_Selva("Uma arena escondida na selva, cheia de vida e perigos naturais") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("A natureza selvagem da arena assusta " + heroi.getNome());
            //heroi.aumentarResistencia(4);
        }
    },
                
    Estádio_goblin("Um estádio caótico onde goblins travam batalhas frenéticas") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("A energia caótica do estádio confunde " + heroi.getNome());
            //heroi.aumentarEvasao(6);
        }
    },
                
    Fosso_de_Ossos("Um fosso sombrio repleto de ossos e espíritos inquietos") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("Os espíritos inquietos do fosso drenam a energia de " + heroi.getNome());
            //heroi.reduzirDano(4);
        }
    },
                
    Montanha_Hog("Uma montanha íngreme onde a força bruta é testada ao máximo") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("A escalada árdua fortalece " + heroi.getNome() + ", aumentando sua vida máxima em 20 pontos!");
            //heroi.receberCura(20);
        }
    },
                
    Electro_Valley("Um vale eletrizante onde tempestades constantes energizam os combatentes") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("A eletricidade do vale energiza " + heroi.getNome() + ", aumentando sua velocidade de ataque em 10%!");
            //heroi.aumentarVelocidadeAtaque(10);
        }
    },
                
    Cidade_Assustadora("Uma cidade fantasmagórica onde o medo é uma presença constante") {
        @Override
        public void aplicarEfeitos(Heroi heroi){
            System.out.println("O medo constante na cidade assombra " + heroi.getNome());
            //heroi.reduzirResistencia(5);
        }
    };

    // 1. Atributo para guardar a descrição
    private final String descricao;

    // 2. Construtor para inicializar a descrição
    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    // 3. Método para acessar a descrição
    public String getDescricao() {
        return this.descricao;
    }

    // 4. Método abstrato que FORÇA cada cenário a ter seu próprio efeito
    public abstract void aplicarEfeitos(Heroi heroi);

}   
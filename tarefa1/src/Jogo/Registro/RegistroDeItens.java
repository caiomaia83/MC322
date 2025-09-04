package Jogo.Registro;

import java.util.ArrayList;
import java.util.List;
import Itens.*;
import Itens.Acessorios.RecrutasReais.*;
import Itens.Armas.Herois.Arqueira.*;
import Itens.Armas.Herois.Bárbaros.*;
import Itens.Armas.Herois.RecrutasReais.*;
import Itens.Armas.Monstros.Corredor.DemolidorDeTorres;
import Itens.Armas.Monstros.Esqueletos.Comum.*;
import Itens.Armas.Monstros.Esqueletos.Incomum.*;
import Itens.Armas.Monstros.Servos.Comum.GarraDeServo;
import Itens.Armas.Monstros.Servos.Incomum.FerraoDeServo;


// Um registro geral de todos os itens no jogo para facilitar a construcao de novos metodos 
public class RegistroDeItens {
    
    public static final List<Item> TODOS_OS_ITENS = new ArrayList<>();

    static {
        // ========= ITENS GERAIS ========== //
        
        
        // ----- ITENS ARQUEIRA ------ //
        /*          Armas            */ 
        TODOS_OS_ITENS.add(new ArcoCurto());
        
        
        // ----- ITENS BARBAROS ----- //
        /*          Armas            */
        TODOS_OS_ITENS.add(new CuteloDeCaça());
        TODOS_OS_ITENS.add(new QuebraOssos());
        
        
        // --- ITENS RECRUTA REAIS --- //
        /*          Armas            */
        TODOS_OS_ITENS.add(new LancaDeTreinamento());
        TODOS_OS_ITENS.add(new PiqueDeInfantaria());
        /*          Acessórios       */
        TODOS_OS_ITENS.add(new EscudoDeMadeira());

        
        
        
        // ============ ITENS MONSTROS ============ //
        
        // ----- ITENS ESQUELETOS ----- //
        /*          Armas            */
        TODOS_OS_ITENS.add(new EspadaoLascado());
        TODOS_OS_ITENS.add(new LaminaCerimonial());
        TODOS_OS_ITENS.add(new AlfangeDoFosso());

        
        // ----- ITENS SERVOS ----- //
        /*          Armas           */
        TODOS_OS_ITENS.add(new GarraDeServo());
        TODOS_OS_ITENS.add(new FerraoDeServo());


        // ----- ITENS CORREDOR ----- //
        /*          Armas           */
        TODOS_OS_ITENS.add(new DemolidorDeTorres());
        
    }
}

package Jogo.Registro;

import java.util.ArrayList;
import java.util.List;
import Itens.*;
import Itens.Acessorios.RecrutasReais.*;
import Itens.Armas.ArmasBase.Gerais.*;
import Itens.Armas.Herois.Arqueira.*;
import Itens.Armas.Herois.Bárbaros.Comum.*;
import Itens.Armas.Herois.Bárbaros.Epico.RugidoDoBerserker;
import Itens.Armas.Herois.Bárbaros.Incomum.*;
import Itens.Armas.Herois.Bárbaros.Raro.Devoradora;
import Itens.Armas.Herois.RecrutasReais.*;
import Itens.Armas.Monstros.Corredor.DemolidorDeTorres;
import Itens.Armas.Monstros.Esqueletos.Comum.*;
import Itens.Armas.Monstros.Esqueletos.Epico.*;
import Itens.Armas.Monstros.Esqueletos.Incomum.*;
import Itens.Armas.Monstros.Esqueletos.Lendario.*;
import Itens.Armas.Monstros.Esqueletos.Raro.*;
import Itens.Armas.Monstros.Servos.Comum.*;
import Itens.Armas.Monstros.Servos.Incomum.*;


// Um registro geral de todos os itens no jogo para facilitar a construcao de novos metodos 
public class RegistroDeItens {
    
    public static final List<Item> TODOS_OS_ITENS = new ArrayList<>();

    static {
        // ========= ITENS GERAIS ========== //

        TODOS_OS_ITENS.add(new GalhoRobusto());
        
        // ========= ITENS HEROIS ========== //

        // ----- ITENS ARQUEIRA ------ //
        /*          Armas            */ 
        // Comum
        TODOS_OS_ITENS.add(new ArcoCurto());
        TODOS_OS_ITENS.add(new PrimeiraClava());
        TODOS_OS_ITENS.add(new PeDeCadeira());
        TODOS_OS_ITENS.add(new EspadaCurta());
        
        
        // ----- ITENS BARBAROS ----- //
        /*          Armas            */
        // Comum
        TODOS_OS_ITENS.add(new CuteloDeCaça());
        TODOS_OS_ITENS.add(new QuebraOssos());
        // Incomum
        TODOS_OS_ITENS.add(new QuebraCranios());
        // Raro
        TODOS_OS_ITENS.add(new Devoradora());
        // Épico
        TODOS_OS_ITENS.add(new RugidoDoBerserker());
        
        
        // --- ITENS RECRUTA REAIS --- //
        /*          Armas            */
        // Comum
        TODOS_OS_ITENS.add(new LancaDeTreinamento());
        TODOS_OS_ITENS.add(new PiqueDeInfantaria());
        
        /*          Escudos       */
        // Comum
        TODOS_OS_ITENS.add(new EscudoDeMadeira());

        
        
        
        // ============ ITENS MONSTROS ============ //
        
        // ----- ITENS ESQUELETOS ----- //
        /*          Armas            */
        // Comum
        TODOS_OS_ITENS.add(new EspadaoLascado());
        TODOS_OS_ITENS.add(new LaminaCerimonial());
        TODOS_OS_ITENS.add(new LascaDeOsso());
        TODOS_OS_ITENS.add(new AgulhaDeOsso());
        TODOS_OS_ITENS.add(new PedraDeTumba());
        // Incomum
        TODOS_OS_ITENS.add(new AlfangeDoFosso());
        TODOS_OS_ITENS.add(new AdagaCerimonial());
        TODOS_OS_ITENS.add(new ArcoDeOsso());
        // Raro
        TODOS_OS_ITENS.add(new GladioDoLegionario());
        TODOS_OS_ITENS.add(new DesmembradorDeCripta());
        TODOS_OS_ITENS.add(new EsmagadorDeVontades());
        // Épico
        TODOS_OS_ITENS.add(new FragmentoDeSilencio());
        TODOS_OS_ITENS.add(new EspinhaDeDragao());
        //Lendário
        TODOS_OS_ITENS.add(new VisaoDoCeifador());

        
        // ----- ITENS SERVOS ----- //
        /*          Armas           */
        // Comum
        TODOS_OS_ITENS.add(new GarraDeServo());
        // Incomum
        TODOS_OS_ITENS.add(new FerraoDeServo());


        // ----- ITENS CORREDOR ----- //
        /*          Armas           */
        // Épico
        TODOS_OS_ITENS.add(new DemolidorDeTorres());
        
    }
}

package com.rpg.game.itens.Registro;

import java.util.ArrayList;
import java.util.List;

import com.rpg.game.itens.*;
import com.rpg.game.itens.Acessorios.RecrutasReais.*;
import com.rpg.game.itens.Armas.ArmasBase.Gerais.*;
import com.rpg.game.itens.Armas.ArmasHerois.Arqueira.*;
import com.rpg.game.itens.Armas.ArmasHerois.Bárbaros.Comum.*;
import com.rpg.game.itens.Armas.ArmasHerois.Bárbaros.Epico.*;
import com.rpg.game.itens.Armas.ArmasHerois.Bárbaros.Incomum.*;
import com.rpg.game.itens.Armas.ArmasHerois.Bárbaros.Raro.*;
import com.rpg.game.itens.Armas.ArmasHerois.RecrutasReais.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Corredor.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Comum.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Epico.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Incomum.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Lendario.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Raro.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Servos.Comum.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Servos.Incomum.*;


// Um registro geral de todos os itens no jogo para facilitar a construcao de novos metodos 
public class RegistroDeItens {
    
    public static final List<Item> TODOS_OS_ITENS = new ArrayList<>();

    static {
        // ========= ITENS GERAIS ========== //

        TODOS_OS_ITENS.add(new GalhoRobusto());
        TODOS_OS_ITENS.add(new PrimeiraClava());
        TODOS_OS_ITENS.add(new PeDeCadeira());
        TODOS_OS_ITENS.add(new EspadaCurta());
        
        // ========= ITENS HEROIS ========== //

        // ----- ITENS ARQUEIRA ------ //
        /*          Armas            */ 
        // Comum
        TODOS_OS_ITENS.add(new ArcoCurto());
        
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
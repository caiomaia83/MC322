package com.rpg.itens.Registro;

import java.util.ArrayList;
import java.util.List;

import com.rpg.itens.*;
import com.rpg.itens.Acessorios.RecrutasReais.*;
import com.rpg.itens.Armas.Herois.Arqueira.*;
import com.rpg.itens.Armas.Herois.Bárbaros.*;

import com.rpg.itens.Armas.Herois.RecrutasReais.*;
import com.rpg.itens.Armas.Monstros.Corredor.*;
import com.rpg.itens.Armas.Monstros.Esqueletos.Comum.*;
import com.rpg.itens.Armas.Monstros.Esqueletos.Incomum.*;
import com.rpg.itens.Armas.Monstros.Servos.Incomum.*;


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

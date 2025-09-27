package com.rpg.itens;

import com.rpg.itens.Classificadores.*;



// Classe de itens ( Armas, consumiveis, armaduras )
public class Item implements IItem{
    private String nome;
    private String descricao;
    private Raridade raridade;
    private OrigemDoItem origem; // Guarda a origem do item 
    private TipoDeItem tipoDeItem; // Guarda o tipo de item

    public Item(String nome, Raridade raridade, OrigemDoItem origem, TipoDeItem tipoDeItem) {
        this.nome = nome;
        this.raridade = raridade;
        this.origem = origem;
        this.tipoDeItem = tipoDeItem;

    }

    public String getNome() {
        return this.nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao; 
    }

    public Raridade getRaridade() {
        return this.raridade;
    }

    protected void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public OrigemDoItem getOrigemDoItem() {
        return this.origem;
    }

    public TipoDeItem getTipoDeItem() {
        return this.tipoDeItem;
    }
}

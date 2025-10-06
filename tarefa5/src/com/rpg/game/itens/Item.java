package com.rpg.game.itens;

import com.rpg.game.itens.Classificadores.*;


/**
 * Classe base para todos os itens do jogo (armas, consumíveis, armaduras, etc.).
 * <p>
 * Esta classe implementa a interface {@link IItem} e contém os atributos
 * comuns a todos os itens, como nome, descrição, raridade, origem e tipo.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class Item implements InterfaceItem{
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

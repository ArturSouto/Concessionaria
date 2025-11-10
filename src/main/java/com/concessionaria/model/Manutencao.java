package com.concessionaria.model;

public class Manutencao {
    private String idmanutencao;
    private int id;
    private String descricao;
    private int custos;
    private String dataManutencao;

    public String getIdmanutencao() { return idmanutencao; }
    public void setIdmanutencao(String idmanutencao) { this.idmanutencao = idmanutencao; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getCustos() { return custos; }
    public void setCustos(int custos) { this.custos = custos; }

    public String getDataManutencao() { return dataManutencao; }
    public void setDataManutencao(String dataManutencao) { this.dataManutencao = dataManutencao; }
}

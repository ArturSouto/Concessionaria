package com.concessionaria.model;

public class Pecas {
    private String idmanutencao;
    private String codPeca;
    private String nome;
    private String material;

    public String getIdmanutencao() { return idmanutencao; }
    public void setIdmanutencao(String idmanutencao) { this.idmanutencao = idmanutencao; }

    public String getCodPeca() { return codPeca; }
    public void setCodPeca(String codPeca) { this.codPeca = codPeca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}

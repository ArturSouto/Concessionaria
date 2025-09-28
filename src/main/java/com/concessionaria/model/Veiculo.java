package com.concessionaria.model;

import java.math.BigDecimal;

public class Veiculo {
    private int id;
    private Integer ano;
    private Integer km;
    private String cor;
    private String estado;
    private BigDecimal preco;
    private String modelo;
    private String combustivel;
    private String CNPJ;

    public Veiculo() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getCombustivel() { return combustivel; }
    public void setCombustivel(String combustivel) { this.combustivel = combustivel; }
    public String getCNPJ() { return CNPJ; }
    public void setCNPJ(String CNPJ) { this.CNPJ = CNPJ; }
}

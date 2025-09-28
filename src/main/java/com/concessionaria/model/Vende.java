package com.concessionaria.model;

import java.util.Date;

public class Vende {
    private String idvenda;
    private int id;
    private String CPF;
    private String CNPJ;
    private java.sql.Date DataVenda;
    private int valorVenda;
    private String formaPagamento;

    public Vende() {}

    public String getIdvenda() { return idvenda; }
    public void setIdvenda(String idvenda) { this.idvenda = idvenda; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCPF() { return CPF; }
    public void setCPF(String cPF) { CPF = cPF; }
    public String getCNPJ() { return CNPJ; }
    public void setCNPJ(String cNPJ) { CNPJ = cNPJ; }
    public java.sql.Date getDataVenda() { return DataVenda; }
    public void setDataVenda(java.sql.Date dataVenda) { DataVenda = dataVenda; }
    public int getValorVenda() { return valorVenda; }
    public void setValorVenda(int valorVenda) { this.valorVenda = valorVenda; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}

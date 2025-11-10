package com.concessionaria.model;

public class Vende {
    private String idvenda;
    private int id;
    private String cpf;
    private String cnpj;
    private String dataVenda;
    private int valorVenda;
    private String formaPagamento;

    public String getIdvenda() { return idvenda; }
    public void setIdvenda(String idvenda) { this.idvenda = idvenda; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getDataVenda() { return dataVenda; }
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }

    public int getValorVenda() { return valorVenda; }
    public void setValorVenda(int valorVenda) { this.valorVenda = valorVenda; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}

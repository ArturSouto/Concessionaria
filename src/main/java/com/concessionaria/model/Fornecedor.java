package com.concessionaria.model;

public class Fornecedor {
    private String CNPJ;
    private String Nome;
    private String Nome_Fantasia;
    private String Telefone;

    public Fornecedor() {}

    public String getCNPJ() { return CNPJ; }
    public void setCNPJ(String CNPJ) { this.CNPJ = CNPJ; }
    public String getNome() { return Nome; }
    public void setNome(String nome) { Nome = nome; }
    public String getNome_Fantasia() { return Nome_Fantasia; }
    public void setNome_Fantasia(String nome_Fantasia) { Nome_Fantasia = nome_Fantasia; }
    public String getTelefone() { return Telefone; }
    public void setTelefone(String telefone) { Telefone = telefone; }
}

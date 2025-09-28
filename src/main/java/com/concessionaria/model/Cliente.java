package com.concessionaria.model;

public class Cliente {
    private String CPF;
    private String Nome;
    private int idade;
    private Integer enderecoCEP;
    private String enderecoBairro;
    private String enderecoRua;
    private Integer enderecoNumero;

    public Cliente() {}

    public String getCPF() { return CPF; }
    public void setCPF(String cPF) { CPF = cPF; }
    public String getNome() { return Nome; }
    public void setNome(String nome) { Nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public Integer getEnderecoCEP() { return enderecoCEP; }
    public void setEnderecoCEP(Integer enderecoCEP) { this.enderecoCEP = enderecoCEP; }
    public String getEnderecoBairro() { return enderecoBairro; }
    public void setEnderecoBairro(String enderecoBairro) { this.enderecoBairro = enderecoBairro; }
    public String getEnderecoRua() { return enderecoRua; }
    public void setEnderecoRua(String enderecoRua) { this.enderecoRua = enderecoRua; }
    public Integer getEnderecoNumero() { return enderecoNumero; }
    public void setEnderecoNumero(Integer enderecoNumero) { this.enderecoNumero = enderecoNumero; }
}

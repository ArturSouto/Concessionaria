package com.concessionaria.model;

public class Cliente {
    private String cpf;
    private String nome;
    private int idade;
    private String enderecoCEP;
    private String enderecoBairro;
    private String enderecoRua;
    private String enderecoNumero;
    private String email;

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getEnderecoCEP() { return enderecoCEP; }
    public void setEnderecoCEP(String enderecoCEP) { this.enderecoCEP = enderecoCEP; }

    public String getEnderecoBairro() { return enderecoBairro; }
    public void setEnderecoBairro(String enderecoBairro) { this.enderecoBairro = enderecoBairro; }

    public String getEnderecoRua() { return enderecoRua; }
    public void setEnderecoRua(String enderecoRua) { this.enderecoRua = enderecoRua; }

    public String getEnderecoNumero() { return enderecoNumero; }
    public void setEnderecoNumero(String enderecoNumero) { this.enderecoNumero = enderecoNumero; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

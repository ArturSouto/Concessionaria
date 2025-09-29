package com.concessionaria.model;

public class Funcionario {
    private String cpf;
    private int salario;
    private String cargo;
    private String contratacao; // Pode usar String para simplificar no front, ou java.sql.Date
    private String supervisorCPF;
    private String enderecoCEP;
    private String enderecoBairro;
    private String enderecoRua;
    private int enderecoNumero;

    // Getters e setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getSalario() { return salario; }
    public void setSalario(int salario) { this.salario = salario; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getContratacao() { return contratacao; }
    public void setContratacao(String contratacao) { this.contratacao = contratacao; }

    public String getSupervisorCPF() { return supervisorCPF; }
    public void setSupervisorCPF(String supervisorCPF) { this.supervisorCPF = supervisorCPF; }

    public String getEnderecoCEP() { return enderecoCEP; }
    public void setEnderecoCEP(String enderecoCEP) { this.enderecoCEP = enderecoCEP; }

    public String getEnderecoBairro() { return enderecoBairro; }
    public void setEnderecoBairro(String enderecoBairro) { this.enderecoBairro = enderecoBairro; }

    public String getEnderecoRua() { return enderecoRua; }
    public void setEnderecoRua(String enderecoRua) { this.enderecoRua = enderecoRua; }

    public int getEnderecoNumero() { return enderecoNumero; }
    public void setEnderecoNumero(int enderecoNumero) { this.enderecoNumero = enderecoNumero; }
}

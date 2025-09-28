package com.concessionaria.model;

public class Funcionario {
    private String CPF;
    private int salario;
    private String cargo;
    private String contratacao;
    private String SupervisorCPF;
    private Integer enderecoCEP;
    private String enderecoBairro;
    private String enderecoRua;
    private Integer enderecoNumero;

    public Funcionario() {}

    // Getters and setters
    public String getCPF() { return CPF; }
    public void setCPF(String cPF) { CPF = cPF; }
    public int getSalario() { return salario; }
    public void setSalario(int salario) { this.salario = salario; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public String getContratacao() { return contratacao; }
    public void setContratacao(String contratacao) { this.contratacao = contratacao; }
    public String getSupervisorCPF() { return SupervisorCPF; }
    public void setSupervisorCPF(String supervisorCPF) { SupervisorCPF = supervisorCPF; }
    public Integer getEnderecoCEP() { return enderecoCEP; }
    public void setEnderecoCEP(Integer enderecoCEP) { this.enderecoCEP = enderecoCEP; }
    public String getEnderecoBairro() { return enderecoBairro; }
    public void setEnderecoBairro(String enderecoBairro) { this.enderecoBairro = enderecoBairro; }
    public String getEnderecoRua() { return enderecoRua; }
    public void setEnderecoRua(String enderecoRua) { this.enderecoRua = enderecoRua; }
    public Integer getEnderecoNumero() { return enderecoNumero; }
    public void setEnderecoNumero(Integer enderecoNumero) { this.enderecoNumero = enderecoNumero; }
}

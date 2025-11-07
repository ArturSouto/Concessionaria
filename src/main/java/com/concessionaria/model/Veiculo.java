package com.concessionaria.model;

public class Veiculo {
    private int id;
    private int ano;
    private int km;
    private String cor;
    private String estado;
    private double preco;
    private String modelo;
    private String combustivel;
    private String cnpj;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getKm() { return km; }
    public void setKm(int km) { this.km = km; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCombustivel() { return combustivel; }
    public void setCombustivel(String combustivel) { this.combustivel = combustivel; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}

package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    // ---------- 1) Listar carros ----------
    public List<String> listarCarros() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT modelo, fabricante, ano FROM Carro ORDER BY fabricante";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String linha = rs.getString("modelo") + " - " +
                        rs.getString("fabricante") + " - " +
                        rs.getInt("ano");
                lista.add(linha);
            }
        }
        return lista;
    }

    // ---------- 2) Listar clientes ----------
    public List<String> listarClientes() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome, idade, CPF FROM Cliente ORDER BY nome";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String linha = rs.getString("nome") + " - Idade: " +
                        rs.getInt("idade") + " - CPF: " +
                        rs.getString("CPF");
                lista.add(linha);
            }
        }
        return lista;
    }

    // ---------- 3) Listar funcionários ----------
    public List<String> listarFuncionarios() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome, cargo, CPF FROM Funcionario ORDER BY cargo";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String linha = rs.getString("nome") + " - Cargo: " +
                        rs.getString("cargo") + " - CPF: " +
                        rs.getString("CPF");
                lista.add(linha);
            }
        }
        return lista;
    }

    // ---------- 4) Listar vendas ----------
    public List<String> listarVendas() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql =
                "SELECT V.idvenda, C.nome AS cliente, F.nome AS funcionario, Ve.placa AS veiculo " +
                "FROM Vende V " +
                "JOIN Cliente C ON V.CPFCliente = C.CPF " +
                "JOIN Funcionario F ON V.CPFFuncionario = F.CPF " +
                "JOIN Veiculo Ve ON V.idveiculo = Ve.idveiculo";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String linha = "Venda " + rs.getInt("idvenda") +
                        " - Cliente: " + rs.getString("cliente") +
                        " - Funcionário: " + rs.getString("funcionario") +
                        " - Veículo: " + rs.getString("veiculo");

                lista.add(linha);
            }
        }
        return lista;
    }

    // ---------- 5) Listar veículos ----------
    public List<String> listarVeiculos() throws SQLException {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT placa, modelo FROM Veiculo ORDER BY modelo";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String linha = rs.getString("placa") + " - " + rs.getString("modelo");
                lista.add(linha);
            }
        }
        return lista;
    }
}
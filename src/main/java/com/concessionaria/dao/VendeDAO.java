package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Vende;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendeDAO {

    // ==================================
    // INSERIR
    // ==================================
    public void inserir(Vende venda) throws Exception {
        String sql = "INSERT INTO vende (idvenda, id, cpf, cnpj, dataVenda, valorVenda, formaPagamento) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, venda.getIdvenda());
            stmt.setInt(2, venda.getId());
            stmt.setString(3, venda.getCpf());
            stmt.setString(4, venda.getCnpj());
            stmt.setDate(5, Date.valueOf(venda.getDataVenda()));  // String → Date
            stmt.setInt(6, venda.getValorVenda());
            stmt.setString(7, venda.getFormaPagamento());

            stmt.executeUpdate();
        }
    }

    // ==================================
    // LISTAR TODOS
    // ==================================
    public List<Vende> listarTodos() throws Exception {
        String sql = "SELECT * FROM vende";

        List<Vende> lista = new ArrayList<>();

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vende venda = new Vende();

                venda.setIdvenda(rs.getString("idvenda"));
                venda.setId(rs.getInt("id"));
                venda.setCpf(rs.getString("cpf"));
                venda.setCnpj(rs.getString("cnpj"));
                venda.setDataVenda(rs.getDate("dataVenda").toString());
                venda.setValorVenda(rs.getInt("valorVenda"));
                venda.setFormaPagamento(rs.getString("formaPagamento"));

                lista.add(venda);
            }
        }

        return lista;
    }

    // ==================================
    // BUSCAR POR ID
    // ==================================
    public Vende buscarPorId(String idvenda) throws Exception {
        String sql = "SELECT * FROM vende WHERE idvenda = ?";
        Vende venda = null;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idvenda);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                venda = new Vende();

                venda.setIdvenda(rs.getString("idvenda"));
                venda.setId(rs.getInt("id"));
                venda.setCpf(rs.getString("cpf"));
                venda.setCnpj(rs.getString("cnpj"));
                venda.setDataVenda(rs.getDate("dataVenda").toString());
                venda.setValorVenda(rs.getInt("valorVenda"));
                venda.setFormaPagamento(rs.getString("formaPagamento"));
            }
        }

        return venda;
    }

    // ==================================
    // ATUALIZAR
    // ==================================
    public void atualizar(Vende venda) throws Exception {
        String sql = "UPDATE vende SET id = ?, cpf = ?, cnpj = ?, dataVenda = ?, valorVenda = ?, formaPagamento = ? " +
                     "WHERE idvenda = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getId());
            stmt.setString(2, venda.getCpf());
            stmt.setString(3, venda.getCnpj());
            stmt.setDate(4, Date.valueOf(venda.getDataVenda()));
            stmt.setInt(5, venda.getValorVenda());
            stmt.setString(6, venda.getFormaPagamento());
            stmt.setString(7, venda.getIdvenda());

            stmt.executeUpdate();
        }
    }

    // ==================================
    // DELETAR
    // ==================================
    public void deletar(String idvenda) throws Exception {
        String sql = "DELETE FROM vende WHERE idvenda = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idvenda);
            stmt.executeUpdate();
        }
    }
}
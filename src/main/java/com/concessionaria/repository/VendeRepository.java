package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Vende;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendeRepository {

    public void inserir(Vende vende) {
        String sql = "INSERT INTO Vende (idvenda, id, CPF, CNPJ, DataVenda, valorVenda, formaPagamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vende.getIdvenda());
            stmt.setInt(2, vende.getId());
            stmt.setString(3, vende.getCpf());
            stmt.setString(4, vende.getCnpj());
            stmt.setString(5, vende.getDataVenda());
            stmt.setInt(6, vende.getValorVenda());
            stmt.setString(7, vende.getFormaPagamento());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Vende vende) {
        String sql = "UPDATE Vende SET id=?, CPF=?, CNPJ=?, DataVenda=?, valorVenda=?, formaPagamento=? WHERE idvenda=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vende.getId());
            stmt.setString(2, vende.getCpf());
            stmt.setString(3, vende.getCnpj());
            stmt.setString(4, vende.getDataVenda());
            stmt.setInt(5, vende.getValorVenda());
            stmt.setString(6, vende.getFormaPagamento());
            stmt.setString(7, vende.getIdvenda());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String idvenda) {
        String sql = "DELETE FROM Vende WHERE idvenda=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idvenda);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vende> listar() {
        List<Vende> vendas = new ArrayList<>();
        String sql = "SELECT * FROM Vende";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vende vende = new Vende();
                vende.setIdvenda(rs.getString("idvenda"));
                vende.setId(rs.getInt("id"));
                vende.setCpf(rs.getString("CPF"));
                vende.setCnpj(rs.getString("CNPJ"));
                vende.setDataVenda(rs.getString("DataVenda"));
                vende.setValorVenda(rs.getInt("valorVenda"));
                vende.setFormaPagamento(rs.getString("formaPagamento"));

                vendas.add(vende);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }
}

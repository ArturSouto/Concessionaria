package com.concessionaria.service;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {

    public void salvarVeiculo(Veiculo v) throws SQLException {
        String sql = "INSERT INTO veiculo (id, ano, km, cor, estado, preco, modelo, combustivel, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, v.getId());
            ps.setInt(2, v.getAno());
            ps.setInt(3, v.getKm());
            ps.setString(4, v.getCor());
            ps.setString(5, v.getEstado());
            ps.setDouble(6, v.getPreco());
            ps.setString(7, v.getModelo());
            ps.setString(8, v.getCombustivel());
            ps.setString(9, v.getCnpj());
            ps.executeUpdate();
        }
    }

    public void atualizarVeiculo(Veiculo v) throws SQLException {
        String sql = "UPDATE veiculo SET ano=?, km=?, cor=?, estado=?, preco=?, modelo=?, combustivel=?, cnpj=? WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, v.getAno());
            ps.setInt(2, v.getKm());
            ps.setString(3, v.getCor());
            ps.setString(4, v.getEstado());
            ps.setDouble(5, v.getPreco());
            ps.setString(6, v.getModelo());
            ps.setString(7, v.getCombustivel());
            ps.setString(8, v.getCnpj());
            ps.setInt(9, v.getId());
            ps.executeUpdate();
        }
    }

    public void deletarVeiculo(int id) throws SQLException {
        String sql = "DELETE FROM veiculo WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Veiculo> listarTodos() throws SQLException {
        List<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getInt("id"));
                v.setAno(rs.getInt("ano"));
                v.setKm(rs.getInt("km"));
                v.setCor(rs.getString("cor"));
                v.setEstado(rs.getString("estado"));
                v.setPreco(rs.getDouble("preco"));
                v.setModelo(rs.getString("modelo"));
                v.setCombustivel(rs.getString("combustivel"));
                v.setCnpj(rs.getString("cnpj"));
                lista.add(v);
            }
        }
        return lista;
    }
}

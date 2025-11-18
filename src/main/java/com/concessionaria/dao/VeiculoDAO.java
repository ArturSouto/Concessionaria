package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    public void inserir(Veiculo v) throws SQLException {
        String sql = "INSERT INTO Veiculo (id, ano, km, cor, estado, preco, modelo, combustivel, CNPJ) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

    public List<Veiculo> listarTodos() throws SQLException {
        List<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Veiculo";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

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
                v.setCnpj(rs.getString("CNPJ"));

                lista.add(v);
            }
        }
        return lista;
    }

    public Veiculo buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Veiculo WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Veiculo v = new Veiculo();

                    v.setId(rs.getInt("id"));
                    v.setAno(rs.getInt("ano"));
                    v.setKm(rs.getInt("km"));
                    v.setCor(rs.getString("cor"));
                    v.setEstado(rs.getString("estado"));
                    v.setPreco(rs.getDouble("preco"));
                    v.setModelo(rs.getString("modelo"));
                    v.setCombustivel(rs.getString("combustivel"));
                    v.setCnpj(rs.getString("CNPJ"));

                    return v;
                }
            }
        }
        return null;
    }

    public void atualizar(Veiculo v) throws SQLException {
        String sql = "UPDATE Veiculo SET ano=?, km=?, cor=?, estado=?, preco=?, modelo=?, combustivel=?, CNPJ=? " +
                     "WHERE id=?";

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

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Veiculo WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
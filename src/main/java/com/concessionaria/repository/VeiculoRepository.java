
package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Veiculo;
import java.sql.*;
import java.util.*;

public class VeiculoRepository {

    public boolean insert(Veiculo obj) {
        String sql = "INSERT INTO Veiculo (id, ano, km, cor, estado, preco, modelo, combustivel, CNPJ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getId());
            if (obj.getAno() != null) ps.setInt(2, obj.getAno()); else ps.setNull(2, Types.INTEGER);
            if (obj.getKm() != null) ps.setInt(3, obj.getKm()); else ps.setNull(3, Types.INTEGER);
            ps.setString(4, obj.getCor());
            ps.setString(5, obj.getEstado());
            if (obj.getPreco() != null) ps.setBigDecimal(6, obj.getPreco()); else ps.setNull(6, Types.DECIMAL);
            ps.setString(7, obj.getModelo());
            ps.setString(8, obj.getCombustivel());
            ps.setString(9, obj.getCNPJ());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Veiculo> findById(int id) {
        String sql = "SELECT * FROM Veiculo WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Veiculo obj = new Veiculo();
                obj.setId(rs.getInt("id"));
                obj.setAno(rs.getObject("ano") == null ? null : rs.getInt("ano"));
                obj.setKm(rs.getObject("km") == null ? null : rs.getInt("km"));
                obj.setCor(rs.getString("cor"));
                obj.setEstado(rs.getString("estado"));
                obj.setPreco(rs.getBigDecimal("preco"));
                obj.setModelo(rs.getString("modelo"));
                obj.setCombustivel(rs.getString("combustivel"));
                obj.setCNPJ(rs.getString("CNPJ"));
                return Optional.of(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean update(Veiculo obj) {
        String sql = "UPDATE Veiculo SET ano = ?, km = ?, cor = ?, estado = ?, preco = ?, modelo = ?, combustivel = ?, CNPJ = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (obj.getAno() != null) ps.setInt(1, obj.getAno()); else ps.setNull(1, Types.INTEGER);
            if (obj.getKm() != null) ps.setInt(2, obj.getKm()); else ps.setNull(2, Types.INTEGER);
            ps.setString(3, obj.getCor());
            ps.setString(4, obj.getEstado());
            if (obj.getPreco() != null) ps.setBigDecimal(5, obj.getPreco()); else ps.setNull(5, Types.DECIMAL);
            ps.setString(6, obj.getModelo());
            ps.setString(7, obj.getCombustivel());
            ps.setString(8, obj.getCNPJ());
            ps.setInt(9, obj.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Veiculo WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Pecas;
import java.sql.*;
import java.util.*;

public class PecasRepository {

    public boolean insert(Pecas obj) {
        String sql = "INSERT INTO Pecas (idmanutencao, codPeca, nome, material) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getIdmanutencao());
            ps.setString(2, obj.getCodPeca());
            ps.setString(3, obj.getNome());
            ps.setString(4, obj.getMaterial());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Pecas> findById(String id) {
        String sql = "SELECT * FROM Pecas WHERE codPeca = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pecas obj = new Pecas();
                obj.setIdmanutencao(rs.getString("idmanutencao"));
                obj.setCodPeca(rs.getString("codPeca"));
                obj.setNome(rs.getString("nome"));
                obj.setMaterial(rs.getString("material"));
                return Optional.of(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean update(Pecas obj) {
        String sql = "UPDATE Pecas SET idmanutencao = ?, nome = ?, material = ? WHERE codPeca = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getIdmanutencao());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getMaterial());
            ps.setString(4, obj.getCodPeca());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Pecas WHERE codPeca = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

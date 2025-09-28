
package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Manutencao;
import java.sql.*;
import java.util.*;

public class ManutencaoRepository {

    public boolean insert(Manutencao obj) {
        String sql = "INSERT INTO Manutencao (idmanutencao, id, descricao, custos, dataManutencao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getIdmanutencao());
            ps.setInt(2, obj.getId());
            ps.setString(3, obj.getDescricao());
            ps.setInt(4, obj.getCustos());
            ps.setDate(5, obj.getDataManutencao());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Manutencao> findById(String id) {
        String sql = "SELECT * FROM Manutencao WHERE idmanutencao = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Manutencao obj = new Manutencao();
                obj.setIdmanutencao(rs.getString("idmanutencao"));
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setCustos(rs.getInt("custos"));
                obj.setDataManutencao(rs.getDate("dataManutencao"));
                return Optional.of(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean update(Manutencao obj) {
        String sql = "UPDATE Manutencao SET id = ?, descricao = ?, custos = ?, dataManutencao = ? WHERE idmanutencao = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getDescricao());
            ps.setInt(3, obj.getCustos());
            ps.setDate(4, obj.getDataManutencao());
            ps.setString(5, obj.getIdmanutencao());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Manutencao WHERE idmanutencao = ?";
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

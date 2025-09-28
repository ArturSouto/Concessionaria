
package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Vende;
import java.sql.*;
import java.util.*;

public class VendeRepository {

    public boolean insert(Vende obj) {
        String sql = "INSERT INTO Vende (idvenda, id, CPF, CNPJ, DataVenda, valorVenda, formaPagamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getIdvenda());
            ps.setInt(2, obj.getId());
            ps.setString(3, obj.getCPF());
            ps.setString(4, obj.getCNPJ());
            ps.setDate(5, obj.getDataVenda());
            ps.setInt(6, obj.getValorVenda());
            ps.setString(7, obj.getFormaPagamento());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Vende> findById(String id) {
        String sql = "SELECT * FROM Vende WHERE idvenda = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vende obj = new Vende();
                obj.setIdvenda(rs.getString("idvenda"));
                obj.setId(rs.getInt("id"));
                obj.setCPF(rs.getString("CPF"));
                obj.setCNPJ(rs.getString("CNPJ"));
                obj.setDataVenda(rs.getDate("DataVenda"));
                obj.setValorVenda(rs.getInt("valorVenda"));
                obj.setFormaPagamento(rs.getString("formaPagamento"));
                return Optional.of(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean update(Vende obj) {
        String sql = "UPDATE Vende SET id = ?, CPF = ?, CNPJ = ?, DataVenda = ?, valorVenda = ?, formaPagamento = ? WHERE idvenda = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getCPF());
            ps.setString(3, obj.getCNPJ());
            ps.setDate(4, obj.getDataVenda());
            ps.setInt(5, obj.getValorVenda());
            ps.setString(6, obj.getFormaPagamento());
            ps.setString(7, obj.getIdvenda());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Vende WHERE idvenda = ?";
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

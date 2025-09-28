
package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Fornecedor;
import java.sql.*;
import java.util.*;

public class FornecedorRepository {

    public boolean insert(Fornecedor obj) {
        String sql = "INSERT INTO Fornecedor (CNPJ, Nome, Nome_Fantasia, Telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getCNPJ());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getNome_Fantasia());
            ps.setString(4, obj.getTelefone());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Fornecedor> findById(String id) {
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setCNPJ(rs.getString("CNPJ"));
                obj.setNome(rs.getString("Nome"));
                obj.setNome_Fantasia(rs.getString("Nome_Fantasia"));
                obj.setTelefone(rs.getString("Telefone"));
                return Optional.of(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean update(Fornecedor obj) {
        String sql = "UPDATE Fornecedor SET Nome = ?, Nome_Fantasia = ?, Telefone = ? WHERE CNPJ = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getNome_Fantasia());
            ps.setString(3, obj.getTelefone());
            ps.setString(4, obj.getCNPJ());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ = ?";
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

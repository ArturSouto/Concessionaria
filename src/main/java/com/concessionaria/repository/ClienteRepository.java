
package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteRepository {

    public boolean insert(Cliente obj) {
        String sql = "INSERT INTO Cliente (CPF, Nome, idade, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getCPF());
            ps.setString(2, obj.getNome());
            ps.setInt(3, obj.getIdade());
            if (obj.getEnderecoCEP() != null) ps.setInt(4, obj.getEnderecoCEP()); else ps.setNull(4, Types.INTEGER);
            ps.setString(5, obj.getEnderecoBairro());
            ps.setString(6, obj.getEnderecoRua());
            if (obj.getEnderecoNumero() != null) ps.setInt(7, obj.getEnderecoNumero()); else ps.setNull(7, Types.INTEGER);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Cliente> findById(String id) {
        String sql = "SELECT * FROM Cliente WHERE CPF = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCPF(rs.getString("CPF"));
                obj.setNome(rs.getString("Nome"));
                obj.setIdade(rs.getInt("idade"));
                obj.setEnderecoCEP(rs.getObject("enderecoCEP") == null ? null : rs.getInt("enderecoCEP"));
                obj.setEnderecoBairro(rs.getString("enderecoBairro"));
                obj.setEnderecoRua(rs.getString("enderecoRua"));
                obj.setEnderecoNumero(rs.getObject("enderecoNumero") == null ? null : rs.getInt("enderecoNumero"));
                return Optional.of(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean update(Cliente obj) {
        String sql = "UPDATE Cliente SET Nome = ?, idade = ?, enderecoCEP = ?, enderecoBairro = ?, enderecoRua = ?, enderecoNumero = ? WHERE CPF = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNome());
            ps.setInt(2, obj.getIdade());
            if (obj.getEnderecoCEP() != null) ps.setInt(3, obj.getEnderecoCEP()); else ps.setNull(3, Types.INTEGER);
            ps.setString(4, obj.getEnderecoBairro());
            ps.setString(5, obj.getEnderecoRua());
            if (obj.getEnderecoNumero() != null) ps.setInt(6, obj.getEnderecoNumero()); else ps.setNull(6, Types.INTEGER);
            ps.setString(7, obj.getCPF());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Cliente WHERE CPF = ?";
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

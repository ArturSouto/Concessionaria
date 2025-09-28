
package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Funcionario;
import java.sql.*;
import java.util.*;

public class FuncionarioRepository {

    public boolean insert(Funcionario obj) {
        String sql = "INSERT INTO Funcionario (CPF, salario, cargo, contratacao, SupervisorCPF, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getCPF());
            ps.setInt(2, obj.getSalario());
            ps.setString(3, obj.getCargo());
            ps.setString(4, obj.getContratacao());
            ps.setString(5, obj.getSupervisorCPF());
            if (obj.getEnderecoCEP() != null) ps.setInt(6, obj.getEnderecoCEP()); else ps.setNull(6, Types.INTEGER);
            ps.setString(7, obj.getEnderecoBairro());
            ps.setString(8, obj.getEnderecoRua());
            if (obj.getEnderecoNumero() != null) ps.setInt(9, obj.getEnderecoNumero()); else ps.setNull(9, Types.INTEGER);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<Funcionario> findById(String id) {
        String sql = "SELECT * FROM Funcionario WHERE CPF = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setCPF(rs.getString("CPF"));
                obj.setSalario(rs.getInt("salario"));
                obj.setCargo(rs.getString("cargo"));
                obj.setContratacao(rs.getString("contratacao"));
                obj.setSupervisorCPF(rs.getString("SupervisorCPF"));
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

    public boolean update(Funcionario obj) {
        String sql = "UPDATE Funcionario SET salario = ?, cargo = ?, contratacao = ?, SupervisorCPF = ?, enderecoCEP = ?, enderecoBairro = ?, enderecoRua = ?, enderecoNumero = ? WHERE CPF = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getSalario());
            ps.setString(2, obj.getCargo());
            ps.setString(3, obj.getContratacao());
            ps.setString(4, obj.getSupervisorCPF());
            if (obj.getEnderecoCEP() != null) ps.setInt(5, obj.getEnderecoCEP()); else ps.setNull(5, Types.INTEGER);
            ps.setString(6, obj.getEnderecoBairro());
            ps.setString(7, obj.getEnderecoRua());
            if (obj.getEnderecoNumero() != null) ps.setInt(8, obj.getEnderecoNumero()); else ps.setNull(8, Types.INTEGER);
            ps.setString(9, obj.getCPF());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Funcionario WHERE CPF = ?";
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

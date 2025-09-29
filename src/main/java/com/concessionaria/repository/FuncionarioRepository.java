package com.concessionaria.repository;

import com.concessionaria.model.Funcionario;
import com.concessionaria.config.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    public void salvar(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (CPF, salario, cargo, contratacao, SupervisorCPF, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getCpf());
            stmt.setInt(2, funcionario.getSalario());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getContratacao());
            stmt.setString(5, funcionario.getSupervisorCPF());
            stmt.setString(6, funcionario.getEnderecoCEP());
            stmt.setString(7, funcionario.getEnderecoBairro());
            stmt.setString(8, funcionario.getEnderecoRua());
            stmt.setInt(9, funcionario.getEnderecoNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET salario=?, cargo=?, contratacao=?, SupervisorCPF=?, enderecoCEP=?, enderecoBairro=?, enderecoRua=?, enderecoNumero=? WHERE CPF=?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getSalario());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getContratacao());
            stmt.setString(4, funcionario.getSupervisorCPF());
            stmt.setString(5, funcionario.getEnderecoCEP());
            stmt.setString(6, funcionario.getEnderecoBairro());
            stmt.setString(7, funcionario.getEnderecoRua());
            stmt.setInt(8, funcionario.getEnderecoNumero());
            stmt.setString(9, funcionario.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String cpf) {
        String sql = "DELETE FROM Funcionario WHERE CPF=?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCpf(rs.getString("CPF"));
                f.setSalario(rs.getInt("salario"));
                f.setCargo(rs.getString("cargo"));
                f.setContratacao(rs.getString("contratacao"));
                f.setSupervisorCPF(rs.getString("SupervisorCPF"));
                f.setEnderecoCEP(rs.getString("enderecoCEP"));
                f.setEnderecoBairro(rs.getString("enderecoBairro"));
                f.setEnderecoRua(rs.getString("enderecoRua"));
                f.setEnderecoNumero(rs.getInt("enderecoNumero"));
                funcionarios.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}

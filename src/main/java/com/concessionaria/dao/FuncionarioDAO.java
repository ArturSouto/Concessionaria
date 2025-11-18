package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    // ================================
    // INSERT
    // ================================
    public void inserir(Funcionario f) throws SQLException {

        String sql = """
                INSERT INTO Funcionario (
                    CPF, salario, cargo, contratacao,
                    SupervisorCPF, enderecoCEP, enderecoBairro,
                    enderecoRua, enderecoNumero
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getCpf());
            ps.setFloat(2, f.getSalario());
            ps.setString(3, f.getCargo());
            ps.setString(4, f.getContratacao());
            ps.setString(5, f.getSupervisorCPF());
            ps.setString(6, f.getEnderecoCEP());
            ps.setString(7, f.getEnderecoBairro());
            ps.setString(8, f.getEnderecoRua());
            ps.setInt(9, f.getEnderecoNumero());

            ps.executeUpdate();
        }
    }

    // ================================
    // SELECT
    // ================================
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

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

                lista.add(f);
            }
        }

        return lista;
    }

    // ================================
    // UPDATE
    // ================================
    public void atualizar(Funcionario f) throws SQLException {

        String sql = """
                UPDATE Funcionario SET
                    salario=?, cargo=?, contratacao=?, SupervisorCPF=?,
                    enderecoCEP=?, enderecoBairro=?, enderecoRua=?, enderecoNumero=?
                WHERE CPF=?
                """;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setFloat(1, f.getSalario());
            ps.setString(2, f.getCargo());
            ps.setString(3, f.getContratacao());
            ps.setString(4, f.getSupervisorCPF());
            ps.setString(5, f.getEnderecoCEP());
            ps.setString(6, f.getEnderecoBairro());
            ps.setString(7, f.getEnderecoRua());
            ps.setInt(8, f.getEnderecoNumero());
            ps.setString(9, f.getCpf());

            ps.executeUpdate();
        }
    }

    // ================================
    // DELETE
    // ================================
    public void excluir(String cpf) throws SQLException {
        String sql = "DELETE FROM Funcionario WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        }
    }
}
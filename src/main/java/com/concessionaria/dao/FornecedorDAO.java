package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    // ================================
    // INSERT
    // ================================
    public void inserir(Fornecedor f) throws SQLException {
        String sql = "INSERT INTO Fornecedor (CNPJ, Nome, Nome_Fantasia, Telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getCnpj());
            ps.setString(2, f.getNome());
            ps.setString(3, f.getNomeFantasia());
            ps.setString(4, f.getTelefone());

            ps.executeUpdate();
        }
    }

    // ================================
    // SELECT
    // ================================
    public List<Fornecedor> listar() throws SQLException {
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setCnpj(rs.getString("CNPJ"));
                f.setNome(rs.getString("Nome"));
                f.setNomeFantasia(rs.getString("Nome_Fantasia"));
                f.setTelefone(rs.getString("Telefone"));

                lista.add(f);
            }
        }
        return lista;
    }

    // ================================
    // UPDATE
    // ================================
    public void atualizar(Fornecedor f) throws SQLException {
        String sql = "UPDATE Fornecedor SET Nome=?, Nome_Fantasia=?, Telefone=? WHERE CNPJ=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getNome());
            ps.setString(2, f.getNomeFantasia());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getCnpj());

            ps.executeUpdate();
        }
    }

    // ================================
    // DELETE
    // ================================
    public void excluir(String cnpj) throws SQLException {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cnpj);
            ps.executeUpdate();
        }
    }

    // ================================
    // BUSCAR POR CNPJ (corrigido)
    // ================================
    public Fornecedor buscarPorCnpj(String cnpj) throws SQLException {
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cnpj);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Fornecedor f = new Fornecedor();

                    // ❗ CORREÇÃO: AGORA O CNPJ É PREENCHIDO
                    f.setCnpj(rs.getString("CNPJ"));
                    f.setNome(rs.getString("Nome"));
                    f.setNomeFantasia(rs.getString("Nome_Fantasia"));
                    f.setTelefone(rs.getString("Telefone"));

                    return f;
                }
            }
        }

        return null;
    }
}

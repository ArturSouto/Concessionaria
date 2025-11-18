package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorRepository {

    // Inserir fornecedor
    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (CNPJ, Nome, Nome_Fantasia, Telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getNomeFantasia());
            stmt.setString(4, fornecedor.getTelefone());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar fornecedor
    public void atualizar(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET Nome = ?, Nome_Fantasia = ?, Telefone = ? WHERE CNPJ = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNomeFantasia());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getCnpj());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar fornecedor
    public void deletar(String cnpj) {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar fornecedores
    public List<Fornecedor> listar() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setNome(rs.getString("Nome"));
                fornecedor.setNomeFantasia(rs.getString("Nome_Fantasia"));
                fornecedor.setTelefone(rs.getString("Telefone"));

                fornecedores.add(fornecedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedores;
    }


    public Fornecedor buscarPorCnpj(String cnpj) throws SQLException {
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cnpj);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Fornecedor f = new Fornecedor();

                    f.setCnpj(rs.getString("CNPJ")); // <-- FALTAVA ESSA LINHA !!!
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

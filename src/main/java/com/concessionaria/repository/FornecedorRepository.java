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
        String sql = "INSERT INTO Fornecedor (CNPJ, Nome, Nome_Fantasia, Telefone, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getNomeFantasia());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEnderecoCEP());
            stmt.setString(6, fornecedor.getEnderecoBairro());
            stmt.setString(7, fornecedor.getEnderecoRua());
            stmt.setString(8, fornecedor.getEnderecoNumero());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar fornecedor
    public void atualizar(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET Nome=?, Nome_Fantasia=?, Telefone=?, enderecoCEP=?, enderecoBairro=?, enderecoRua=?, enderecoNumero=? WHERE CNPJ=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNomeFantasia());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEnderecoCEP());
            stmt.setString(5, fornecedor.getEnderecoBairro());
            stmt.setString(6, fornecedor.getEnderecoRua());
            stmt.setString(7, fornecedor.getEnderecoNumero());
            stmt.setString(8, fornecedor.getCnpj());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar fornecedor
    public void deletar(String cnpj) {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ=?";

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
                fornecedor.setEnderecoCEP(rs.getString("enderecoCEP"));
                fornecedor.setEnderecoBairro(rs.getString("enderecoBairro"));
                fornecedor.setEnderecoRua(rs.getString("enderecoRua"));
                fornecedor.setEnderecoNumero(rs.getString("enderecoNumero"));

                fornecedores.add(fornecedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedores;
    }

    // Buscar fornecedor por CNPJ
    public Fornecedor buscarPorCnpj(String cnpj) {
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ=?";
        Fornecedor fornecedor = null;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setNome(rs.getString("Nome"));
                fornecedor.setNomeFantasia(rs.getString("Nome_Fantasia"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEnderecoCEP(rs.getString("enderecoCEP"));
                fornecedor.setEnderecoBairro(rs.getString("enderecoBairro"));
                fornecedor.setEnderecoRua(rs.getString("enderecoRua"));
                fornecedor.setEnderecoNumero(rs.getString("enderecoNumero"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornecedor;
    }
}

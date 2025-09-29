package com.concessionaria.repository;

import com.concessionaria.model.Fornecedor;
import com.concessionaria.config.WebConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(WebConfig.DB_URL, WebConfig.DB_USER, WebConfig.DB_PASSWORD);
    }

    public void salvar(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (CNPJ, Nome, Nome_Fantasia, Telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
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

    public void atualizar(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET Nome = ?, Nome_Fantasia = ?, Telefone = ? WHERE CNPJ = ?";
        try (Connection conn = getConnection();
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

    public void deletar(String cnpj) {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Fornecedor buscarPorCnpj(String cnpj) {
        String sql = "SELECT CNPJ, Nome, Nome_Fantasia, Telefone FROM Fornecedor WHERE CNPJ = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setCnpj(rs.getString("CNPJ"));
                f.setNome(rs.getString("Nome"));
                f.setNomeFantasia(rs.getString("Nome_Fantasia"));
                f.setTelefone(rs.getString("Telefone"));
                return f;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Fornecedor> listarTodos() {
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT CNPJ, Nome, Nome_Fantasia, Telefone FROM Fornecedor";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setCnpj(rs.getString("CNPJ"));
                f.setNome(rs.getString("Nome"));
                f.setNomeFantasia(rs.getString("Nome_Fantasia"));
                f.setTelefone(rs.getString("Telefone"));
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    // Inserir cliente
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CPF, Nome, idade, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3, cliente.getIdade());
            stmt.setString(4, cliente.getEnderecoCEP());
            stmt.setString(5, cliente.getEnderecoBairro());
            stmt.setString(6, cliente.getEnderecoRua());
            stmt.setString(7, cliente.getEnderecoNumero());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar cliente
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET Nome=?, idade=?, enderecoCEP=?, enderecoBairro=?, enderecoRua=?, enderecoNumero=? WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getEnderecoCEP());
            stmt.setString(4, cliente.getEnderecoBairro());
            stmt.setString(5, cliente.getEnderecoRua());
            stmt.setString(6, cliente.getEnderecoNumero());
            stmt.setString(7, cliente.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar cliente
    public void deletar(String cpf) {
        String sql = "DELETE FROM Cliente WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar clientes
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("CPF"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEnderecoCEP(rs.getString("enderecoCEP"));
                cliente.setEnderecoBairro(rs.getString("enderecoBairro"));
                cliente.setEnderecoRua(rs.getString("enderecoRua"));
                cliente.setEnderecoNumero(rs.getString("enderecoNumero"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}

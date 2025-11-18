package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CPF, Nome, idade, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3, cliente.getIdade());
            stmt.setString(4, cliente.getEnderecoCEP());
            stmt.setString(5, cliente.getEnderecoBairro());
            stmt.setString(6, cliente.getEnderecoRua());
            stmt.setString(7, cliente.getEnderecoNumero());
            stmt.setString(8, cliente.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET Nome=?, idade=?, enderecoCEP=?, enderecoBairro=?, enderecoRua=?, enderecoNumero=?, email=? WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getEnderecoCEP());
            stmt.setString(4, cliente.getEnderecoBairro());
            stmt.setString(5, cliente.getEnderecoRua());
            stmt.setString(6, cliente.getEnderecoNumero());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                cliente.setEmail(rs.getString("email"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}

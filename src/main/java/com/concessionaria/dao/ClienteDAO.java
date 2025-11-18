package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Cliente;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDAO {

    public void inserir(Cliente c) throws SQLException {
        String sql = "INSERT INTO Cliente (CPF, Nome, idade, enderecoCEP, enderecoBairro, enderecoRua, enderecoNumero, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCpf());
            ps.setString(2, c.getNome());
            ps.setInt(3, c.getIdade());
            ps.setString(4, c.getEnderecoCEP());
            ps.setString(5, c.getEnderecoBairro());
            ps.setString(6, c.getEnderecoRua());
            ps.setString(7, c.getEnderecoNumero());
            ps.setString(8, c.getEmail());

            ps.executeUpdate();
        }
    }

    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("CPF"));
                c.setNome(rs.getString("Nome"));
                c.setIdade(rs.getInt("idade"));
                c.setEnderecoCEP(rs.getString("enderecoCEP"));
                c.setEnderecoBairro(rs.getString("enderecoBairro"));
                c.setEnderecoRua(rs.getString("enderecoRua"));
                c.setEnderecoNumero(rs.getString("enderecoNumero"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        }

        return lista;
    }

    public void atualizar(Cliente c) throws SQLException {
        String sql = "UPDATE Cliente SET Nome=?, idade=?, enderecoCEP=?, enderecoBairro=?, enderecoRua=?, enderecoNumero=?, email=? " +
                "WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setInt(2, c.getIdade());
            ps.setString(3, c.getEnderecoCEP());
            ps.setString(4, c.getEnderecoBairro());
            ps.setString(5, c.getEnderecoRua());
            ps.setString(6, c.getEnderecoNumero());
            ps.setString(7, c.getEmail());
            ps.setString(8, c.getCpf());

            ps.executeUpdate();
        }
    }

    public void deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();
        }
    }

    public Cliente buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE CPF=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setCpf(rs.getString("CPF"));
                    c.setNome(rs.getString("Nome"));
                    c.setIdade(rs.getInt("idade"));
                    c.setEnderecoCEP(rs.getString("enderecoCEP"));
                    c.setEnderecoBairro(rs.getString("enderecoBairro"));
                    c.setEnderecoRua(rs.getString("enderecoRua"));
                    c.setEnderecoNumero(rs.getString("enderecoNumero"));
                    c.setEmail(rs.getString("email"));
                    return c;
                }
            }
        }

        return null;
    }
}

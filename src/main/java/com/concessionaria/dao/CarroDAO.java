package com.concessionaria.dao;

import com.concessionaria.model.Carro;
import com.concessionaria.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    public void inserir(Carro c) {
        String sql = "INSERT INTO Carro (id, portas, cambio) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setInt(2, c.getPortas());
            ps.setString(3, c.getCambio());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir Carro: " + e.getMessage());
        }
    }

    public List<Carro> listar() {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Carro";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Carro c = new Carro();
                c.setId(rs.getInt("id"));
                c.setPortas(rs.getInt("portas"));
                c.setCambio(rs.getString("cambio"));
                lista.add(c);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar Carros: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Carro c) {
        String sql = "UPDATE Carro SET portas=?, cambio=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getPortas());
            ps.setString(2, c.getCambio());
            ps.setInt(3, c.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar Carro: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Carro WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar Carro: " + e.getMessage());
        }
    }
}
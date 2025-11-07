package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {

    public void inserir(Carro carro) {
        String sql = "INSERT INTO Carro (id, portas, cambio) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, carro.getId());
            stmt.setInt(2, carro.getPortas());
            stmt.setString(3, carro.getCambio());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Carro carro) {
        String sql = "UPDATE Carro SET portas=?, cambio=? WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, carro.getPortas());
            stmt.setString(2, carro.getCambio());
            stmt.setInt(3, carro.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Carro WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Carro> listar() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM Carro";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("id"));
                carro.setPortas(rs.getInt("portas"));
                carro.setCambio(rs.getString("cambio"));
                carros.add(carro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carros;
    }
}

package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {

    public void inserir(Carro carro) {
        String sql = "INSERT INTO Carro (portas, cambio) VALUES (?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, carro.getPortas());
            stmt.setString(2, carro.getCambio());

            stmt.executeUpdate();

            // pegar id gerado automaticamente
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                carro.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Carro buscarPorId(int id) {
        String sql = "SELECT * FROM Carro WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Carro carro = new Carro();
                    carro.setId(rs.getInt("id"));
                    carro.setPortas(rs.getInt("portas"));
                    carro.setCambio(rs.getString("cambio"));
                    return carro; // <<--- AGORA RETORNA
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Carro> listar() {
        String sql = "SELECT * FROM Carro";
        List<Carro> carros = new ArrayList<>();

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
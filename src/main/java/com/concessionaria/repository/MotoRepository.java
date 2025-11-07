package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Moto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoRepository {

    public void inserir(Moto moto) {
        String sql = "INSERT INTO Moto (id, cilindradas, tipoMotor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, moto.getId());
            stmt.setInt(2, moto.getCilindradas());
            stmt.setString(3, moto.getTipoMotor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Moto moto) {
        String sql = "UPDATE Moto SET cilindradas=?, tipoMotor=? WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, moto.getCilindradas());
            stmt.setString(2, moto.getTipoMotor());
            stmt.setInt(3, moto.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Moto WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Moto> listar() {
        List<Moto> motos = new ArrayList<>();
        String sql = "SELECT * FROM Moto";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Moto moto = new Moto();
                moto.setId(rs.getInt("id"));
                moto.setCilindradas(rs.getInt("cilindradas"));
                moto.setTipoMotor(rs.getString("tipoMotor"));
                motos.add(moto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motos;
    }
}

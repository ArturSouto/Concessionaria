package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Pecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PecasRepository {

    public void inserir(Pecas peca) {
        String sql = "INSERT INTO Pecas (idmanutencao, codPeca, nome, material) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, peca.getIdmanutencao());
            stmt.setString(2, peca.getCodPeca());
            stmt.setString(3, peca.getNome());
            stmt.setString(4, peca.getMaterial());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Pecas peca) {
        String sql = "UPDATE Pecas SET idmanutencao=?, nome=?, material=? WHERE codPeca=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, peca.getIdmanutencao());
            stmt.setString(2, peca.getNome());
            stmt.setString(3, peca.getMaterial());
            stmt.setString(4, peca.getCodPeca());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String codPeca) {
        String sql = "DELETE FROM Pecas WHERE codPeca=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codPeca);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pecas> listar() {
        List<Pecas> pecas = new ArrayList<>();
        String sql = "SELECT * FROM Pecas";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pecas peca = new Pecas();
                peca.setIdmanutencao(rs.getString("idmanutencao"));
                peca.setCodPeca(rs.getString("codPeca"));
                peca.setNome(rs.getString("nome"));
                peca.setMaterial(rs.getString("material"));

                pecas.add(peca);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pecas;
    }
}

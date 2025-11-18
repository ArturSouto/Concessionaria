package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Pecas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PecasDAO {

    public void inserir(Pecas p) throws SQLException {
        String sql = "INSERT INTO Pecas (idmanutencao, codPeca, nome, material) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getIdmanutencao());
            ps.setString(2, p.getCodPeca());
            ps.setString(3, p.getNome());
            ps.setString(4, p.getMaterial());

            ps.executeUpdate();
        }
    }

    public List<Pecas> listarTodas() throws SQLException {
        List<Pecas> lista = new ArrayList<>();

        String sql = "SELECT * FROM Pecas";
        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Pecas p = new Pecas();
                p.setIdmanutencao(rs.getString("idmanutencao"));
                p.setCodPeca(rs.getString("codPeca"));
                p.setNome(rs.getString("nome"));
                p.setMaterial(rs.getString("material"));

                lista.add(p);
            }
        }
        return lista;
    }

    public Pecas buscarPorId(String codPeca) throws SQLException {
        String sql = "SELECT * FROM Pecas WHERE codPeca = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codPeca);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pecas p = new Pecas();
                    p.setIdmanutencao(rs.getString("idmanutencao"));
                    p.setCodPeca(rs.getString("codPeca"));
                    p.setNome(rs.getString("nome"));
                    p.setMaterial(rs.getString("material"));
                    return p;
                }
            }
        }
        return null;
    }

    public void atualizar(Pecas p) throws SQLException {
        String sql = "UPDATE Pecas SET idmanutencao=?, nome=?, material=? WHERE codPeca=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getIdmanutencao());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getMaterial());
            ps.setString(4, p.getCodPeca());

            ps.executeUpdate();
        }
    }

    public void deletar(String codPeca) throws SQLException {
        String sql = "DELETE FROM Pecas WHERE codPeca=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codPeca);
            ps.executeUpdate();
        }
    }
}
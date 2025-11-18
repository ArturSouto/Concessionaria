package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {

    // ----------------------------
    // INSERIR
    // ----------------------------
    public void inserir(Moto m) throws SQLException {
        String sql = "INSERT INTO Moto (id, cilindradas, tipoMotor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getId());
            ps.setInt(2, m.getCilindradas());
            ps.setString(3, m.getTipoMotor());

            ps.executeUpdate();
        }
    }

    // ----------------------------
    // LISTAR TODAS
    // ----------------------------
    public List<Moto> listarTodas() throws SQLException {
        List<Moto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Moto";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Moto m = new Moto();
                m.setId(rs.getInt("id"));
                m.setCilindradas(rs.getInt("cilindradas"));
                m.setTipoMotor(rs.getString("tipoMotor"));

                lista.add(m);
            }
        }

        return lista;
    }

    // ----------------------------
    // BUSCAR POR ID
    // ----------------------------
    public Moto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Moto WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Moto m = new Moto();
                    m.setId(rs.getInt("id"));
                    m.setCilindradas(rs.getInt("cilindradas"));
                    m.setTipoMotor(rs.getString("tipoMotor"));
                    return m;
                }
            }
        }

        return null;
    }

    // ----------------------------
    // ATUALIZAR
    // ----------------------------
    public void atualizar(Moto m) throws SQLException {
        String sql = "UPDATE Moto SET cilindradas=?, tipoMotor=? WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getCilindradas());
            ps.setString(2, m.getTipoMotor());
            ps.setInt(3, m.getId());

            ps.executeUpdate();
        }
    }

    // ----------------------------
    // DELETAR
    // ----------------------------
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Moto WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

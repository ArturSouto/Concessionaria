package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Carro;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarroDAO {

    public void inserir(Carro c) throws SQLException {
        String sql = "INSERT INTO Carro (id, portas, cambio) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setInt(2, c.getPortas());
            ps.setString(3, c.getCambio());

            ps.executeUpdate();
        }
    }

    public List<Carro> listar() throws SQLException {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Carro";

        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Carro c = new Carro();
                c.setId(rs.getInt("id"));
                c.setPortas(rs.getInt("portas"));
                c.setCambio(rs.getString("cambio"));
                lista.add(c);
            }
        }
        return lista;
    }

    public void atualizar(Carro c) throws SQLException {
        String sql = "UPDATE Carro SET portas=?, cambio=? WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getPortas());
            ps.setString(2, c.getCambio());
            ps.setInt(3, c.getId());

            ps.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Carro WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

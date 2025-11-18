package com.concessionaria.dao;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Manutencao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDAO {

    public void inserir(Manutencao m) throws SQLException {
        String sql = "INSERT INTO Manutencao (idmanutencao, id, descricao, custos, dataManutencao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getIdmanutencao());
            ps.setInt(2, m.getId());
            ps.setString(3, m.getDescricao());
            ps.setInt(4, m.getCustos());

            if (m.getDataManutencao() == null || m.getDataManutencao().isBlank()) {
                ps.setNull(5, Types.DATE);
            } else {
                try {
                    ps.setDate(5, Date.valueOf(m.getDataManutencao())); // espera yyyy-MM-dd
                } catch (IllegalArgumentException e) {
                    throw new SQLException("Formato de data inválido. Use yyyy-MM-dd. Valor: " + m.getDataManutencao(), e);
                }
            }

            ps.executeUpdate();
        }
    }

    public List<Manutencao> listarTodas() throws SQLException {
        List<Manutencao> lista = new ArrayList<>();
        String sql = "SELECT * FROM Manutencao";
        try (Connection conn = ConexaoBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Manutencao m = new Manutencao();
                m.setIdmanutencao(rs.getString("idmanutencao"));
                m.setId(rs.getInt("id"));
                m.setDescricao(rs.getString("descricao"));
                m.setCustos(rs.getInt("custos"));

                Date d = rs.getDate("dataManutencao");
                m.setDataManutencao(d != null ? d.toString() : null);

                lista.add(m);
            }
        }
        return lista;
    }

    public Manutencao buscarPorId(String idmanutencao) throws SQLException {
        String sql = "SELECT * FROM Manutencao WHERE idmanutencao=?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idmanutencao);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Manutencao m = new Manutencao();
                    m.setIdmanutencao(rs.getString("idmanutencao"));
                    m.setId(rs.getInt("id"));
                    m.setDescricao(rs.getString("descricao"));
                    m.setCustos(rs.getInt("custos"));

                    Date d = rs.getDate("dataManutencao");
                    m.setDataManutencao(d != null ? d.toString() : null);

                    return m;
                }
            }
        }
        return null;
    }

    public void atualizar(Manutencao m) throws SQLException {
        String sql = "UPDATE Manutencao SET id=?, descricao=?, custos=?, dataManutencao=? WHERE idmanutencao=?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getId());
            ps.setString(2, m.getDescricao());
            ps.setInt(3, m.getCustos());

            if (m.getDataManutencao() == null || m.getDataManutencao().isBlank()) {
                ps.setNull(4, Types.DATE);
            } else {
                try {
                    ps.setDate(4, Date.valueOf(m.getDataManutencao()));
                } catch (IllegalArgumentException e) {
                    throw new SQLException("Formato de data inválido. Use yyyy-MM-dd. Valor: " + m.getDataManutencao(), e);
                }
            }

            ps.setString(5, m.getIdmanutencao());
            ps.executeUpdate();
        }
    }

    public void deletar(String idmanutencao) throws SQLException {
        String sql = "DELETE FROM Manutencao WHERE idmanutencao=?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idmanutencao);
            ps.executeUpdate();
        }
    }
}
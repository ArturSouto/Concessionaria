package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Manutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoRepository {

    public void inserir(Manutencao manutencao) {
        String sql = "INSERT INTO Manutencao (idmanutencao, id, descricao, custos, dataManutencao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, manutencao.getIdmanutencao());
            stmt.setInt(2, manutencao.getId());
            stmt.setString(3, manutencao.getDescricao());
            stmt.setInt(4, manutencao.getCustos());
            stmt.setString(5, manutencao.getDataManutencao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Manutencao manutencao) {
        String sql = "UPDATE Manutencao SET id=?, descricao=?, custos=?, dataManutencao=? WHERE idmanutencao=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, manutencao.getId());
            stmt.setString(2, manutencao.getDescricao());
            stmt.setInt(3, manutencao.getCustos());
            stmt.setString(4, manutencao.getDataManutencao());
            stmt.setString(5, manutencao.getIdmanutencao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String idmanutencao) {
        String sql = "DELETE FROM Manutencao WHERE idmanutencao=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idmanutencao);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Manutencao> listar() {
        List<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM Manutencao";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Manutencao manutencao = new Manutencao();
                manutencao.setIdmanutencao(rs.getString("idmanutencao"));
                manutencao.setId(rs.getInt("id"));
                manutencao.setDescricao(rs.getString("descricao"));
                manutencao.setCustos(rs.getInt("custos"));
                manutencao.setDataManutencao(rs.getString("dataManutencao"));

                manutencoes.add(manutencao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return manutencoes;
    }
}

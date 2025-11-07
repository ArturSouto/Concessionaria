package com.concessionaria.repository;

import com.concessionaria.config.ConexaoBD;
import com.concessionaria.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository {

    public void inserir(Veiculo veiculo) {
        String sql = "INSERT INTO Veiculo (id, ano, km, cor, estado, preco, modelo, combustivel, CNPJ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, veiculo.getId());
            stmt.setInt(2, veiculo.getAno());
            stmt.setInt(3, veiculo.getKm());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getEstado());
            stmt.setDouble(6, veiculo.getPreco());
            stmt.setString(7, veiculo.getModelo());
            stmt.setString(8, veiculo.getCombustivel());
            stmt.setString(9, veiculo.getCnpj());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Veiculo veiculo) {
        String sql = "UPDATE Veiculo SET ano=?, km=?, cor=?, estado=?, preco=?, modelo=?, combustivel=?, CNPJ=? WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, veiculo.getAno());
            stmt.setInt(2, veiculo.getKm());
            stmt.setString(3, veiculo.getCor());
            stmt.setString(4, veiculo.getEstado());
            stmt.setDouble(5, veiculo.getPreco());
            stmt.setString(6, veiculo.getModelo());
            stmt.setString(7, veiculo.getCombustivel());
            stmt.setString(8, veiculo.getCnpj());
            stmt.setInt(9, veiculo.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Veiculo WHERE id=?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> listar() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM Veiculo";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setKm(rs.getInt("km"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setEstado(rs.getString("estado"));
                veiculo.setPreco(rs.getDouble("preco"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCombustivel(rs.getString("combustivel"));
                veiculo.setCnpj(rs.getString("CNPJ"));

                veiculos.add(veiculo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veiculos;
    }
}

package com.concessionaria.controller;

import com.concessionaria.config.ConexaoBD;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    // Lista nomes dos clientes
    @GetMapping("/clientes")
    public List<String> nomesClientes() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM Cliente";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Lista modelos dos veículos
    @GetMapping("/veiculos")
    public List<String> modelosVeiculos() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT modelo FROM Veiculo";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(rs.getString("modelo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Compradores e veículos
    @GetMapping("/compradores")
    public List<Map<String, String>> compradores() {
        List<Map<String, String>> lista = new ArrayList<>();
        String sql = "SELECT c.Nome, v.modelo " +
                "FROM Cliente c " +
                "JOIN Vende vd ON c.CPF = vd.CPF " +
                "JOIN Veiculo v ON vd.id = v.id";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("nome", rs.getString("Nome"));
                map.put("modelo", rs.getString("modelo"));
                lista.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Média salarial
    @GetMapping("/media-salario")
    public Double mediaSalario() {
        Double media = null;
        String sql = "SELECT AVG(salario) AS media_salario FROM Funcionario";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                media = rs.getDouble("media_salario");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return media;
    }
}

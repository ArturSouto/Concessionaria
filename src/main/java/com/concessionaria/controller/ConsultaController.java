package com.concessionaria.controller;

import com.concessionaria.config.ConexaoBD;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {

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

    @GetMapping("/compradores")
    public List<Map<String, String>> compradores() {
        List<Map<String, String>> lista = new ArrayList<>();
        String sql = """
            SELECT c.Nome, v.modelo
            FROM Cliente c
            JOIN Vende vd ON c.CPF = vd.CPF
            JOIN Veiculo v ON vd.id = v.id
        """;

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

    @GetMapping("/clientes-sem-compras")
    public List<Map<String, Object>> clientesSemCompras() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
            SELECT c.CPF, c.Nome, c.idade
            FROM Cliente c
            LEFT JOIN Vende v ON c.CPF = v.CPF
            WHERE v.CPF IS NULL
        """;

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("cpf", rs.getString("CPF"));
                map.put("nome", rs.getString("Nome"));
                map.put("idade", rs.getInt("idade"));
                lista.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @GetMapping("/fornecedores-vendas")
    public List<Map<String, Object>> fornecedoresVendas() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
            SELECT f.CNPJ AS fornecedor_cnpj, f.Nome AS fornecedor_nome, v.idvenda, v.id AS veiculo_id, v.DataVenda, v.valorVenda
            FROM Fornecedor f
            LEFT JOIN Vende v ON f.CNPJ = v.CNPJ
            UNION
            SELECT f.CNPJ AS fornecedor_cnpj, f.Nome AS fornecedor_nome, v.idvenda, v.id AS veiculo_id, v.DataVenda, v.valorVenda
            FROM Fornecedor f
            RIGHT JOIN Vende v ON f.CNPJ = v.CNPJ
        """;

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("fornecedor_cnpj", rs.getString("fornecedor_cnpj"));
                map.put("fornecedor_nome", rs.getString("fornecedor_nome"));
                map.put("idvenda", rs.getObject("idvenda"));
                map.put("veiculo_id", rs.getObject("veiculo_id"));
                map.put("data_venda", rs.getObject("DataVenda"));
                map.put("valor_venda", rs.getObject("valorVenda"));
                lista.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @GetMapping("/veiculos-acima-media")
    public List<Map<String, Object>> veiculosAcimaMedia() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
            SELECT v.id, v.modelo, v.combustivel, v.preco
            FROM Veiculo v
            WHERE v.preco > (
                SELECT AVG(v2.preco)
                FROM Veiculo v2
                WHERE v2.combustivel = v.combustivel
            )
            ORDER BY v.combustivel, v.preco DESC
        """;

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getInt("id"));
                map.put("modelo", rs.getString("modelo"));
                map.put("combustivel", rs.getString("combustivel"));
                map.put("preco", rs.getDouble("preco"));
                lista.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @GetMapping("/fornecedores-acima-media")
    public List<Map<String, Object>> fornecedoresAcimaMedia() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
            SELECT f.CNPJ, f.Nome, SUM(v.valorVenda) AS total_vendido
            FROM Fornecedor f
            JOIN Veiculo ve ON ve.CNPJ = f.CNPJ
            JOIN Vende v ON v.id = ve.id
            GROUP BY f.CNPJ, f.Nome
            HAVING total_vendido > (
                SELECT AVG(total_por_fornecedor)
                FROM (
                    SELECT SUM(v2.valorVenda) AS total_por_fornecedor
                    FROM Fornecedor f2
                    JOIN Veiculo ve2 ON ve2.CNPJ = f2.CNPJ
                    JOIN Vende v2 ON v2.id = ve2.id
                    GROUP BY f2.CNPJ
                ) AS medias
            )
            ORDER BY total_vendido DESC
        """;

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("CNPJ", rs.getString("CNPJ"));
                map.put("Nome", rs.getString("Nome"));
                map.put("total_vendido", rs.getDouble("total_vendido"));
                lista.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @GetMapping("/venda-detalhada")
    public List<Map<String, Object>> viewVendaDetalhada() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT * FROM venda_detalhada";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int colunas = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> linha = new LinkedHashMap<>();
                for (int i = 1; i <= colunas; i++) {
                    linha.put(meta.getColumnLabel(i), rs.getObject(i));
                }
                lista.add(linha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @GetMapping("/manutencao-completa")
    public List<Map<String, Object>> viewManutencaoCompleta() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT * FROM manutencao_completa";

        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int colunas = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> linha = new LinkedHashMap<>();
                for (int i = 1; i <= colunas; i++) {
                    linha.put(meta.getColumnLabel(i), rs.getObject(i));
                }
                lista.add(linha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

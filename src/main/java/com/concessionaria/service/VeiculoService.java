package com.concessionaria.service;

import com.concessionaria.dao.VeiculoDAO;
import com.concessionaria.model.Veiculo;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoDAO dao = new VeiculoDAO();

    public void salvarVeiculo(Veiculo v) throws SQLException {
        // VALIDAÇÃO CORRETA
        if (v.getAno() < 2010) {
            throw new IllegalArgumentException("Ano deve ser 2010 ou superior.");
        }

        dao.inserir(v);
    }

    public List<Veiculo> listarTodos() throws SQLException {
        return dao.listarTodos();
    }

    public Veiculo buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public void atualizarVeiculo(Veiculo v) throws SQLException {
        if (v.getAno() < 2010) {
            throw new IllegalArgumentException("Ano deve ser 2010 ou superior.");
        }

        dao.atualizar(v);
    }

    public void deletarVeiculo(int id) throws SQLException {
        dao.deletar(id);
    }
}
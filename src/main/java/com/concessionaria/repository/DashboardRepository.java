package com.seuprojeto.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.*;

@Repository
public class DashboardRepository {

    @Autowired
    private EntityManager em;

    public Map<String, Object> empresasPorBairro() {
        Query q = em.createNativeQuery(
                "SELECT bairro, COUNT(*) FROM Empresa GROUP BY bairro"
        );
        List<Object[]> resultados = q.getResultList();

        Map<String, Object> mapa = new LinkedHashMap<>();
        for (Object[] linha : resultados) {
            mapa.put(linha[0].toString(), ((Number) linha[1]).intValue());
        }
        return mapa;
    }

    public Map<String, Object> mediaSalarialPorBairro() {
        Query q = em.createNativeQuery(
                "SELECT bairro, AVG(salario) FROM Funcionario GROUP BY bairro"
        );
        List<Object[]> resultados = q.getResultList();

        Map<String, Object> mapa = new LinkedHashMap<>();
        for (Object[] linha : resultados) {
            mapa.put(linha[0].toString(), ((Number) linha[1]).doubleValue());
        }
        return mapa;
    }

    // --- repita para as outras métricas ---
    public Map<String, Object> clientesPorServico() {
        Query q = em.createNativeQuery(
                "SELECT servico, COUNT(*) FROM Cliente GROUP BY servico"
        );
        List<Object[]> resultados = q.getResultList();

        Map<String, Object> mapa = new LinkedHashMap<>();
        for (Object[] linha : resultados) {
            mapa.put(linha[0].toString(), ((Number) linha[1]).intValue());
        }
        return mapa;
    }

    // continue para requisicoes_empresa, manutencoes_mes, etc...
}

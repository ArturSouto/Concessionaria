
package com.concessionaria.service;

import com.concessionaria.repository.ManutencaoRepository;
import com.concessionaria.model.Manutencao;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class ManutencaoService {{
    private ManutencaoRepository repo = new ManutencaoRepository();

    public boolean create(Manutencao obj) {{
        return repo.insert(obj);
    }}

    public Optional<Manutencao> findById(String id) {{
        return repo.findById(id);
    }}

    public boolean update(Manutencao obj) {{
        return repo.update(obj);
    }}

    public boolean delete(String id) {{
        return repo.delete(id);
    }}
}}

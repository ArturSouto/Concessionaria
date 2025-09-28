
package com.concessionaria.controller;

import com.concessionaria.service.ManutencaoService;
import com.concessionaria.model.Manutencao;
import java.util.Optional;

public class ManutencaoController {{
    private ManutencaoService service = new ManutencaoService();

    public boolean create(Manutencao obj) {{
        return service.create(obj);
    }}

    public Optional<Manutencao> getById(String id) {{
        return service.findById(id);
    }}

    public boolean update(Manutencao obj) {{
        return service.update(obj);
    }}

    public boolean delete(String id) {{
        return service.delete(id);
    }}
}}

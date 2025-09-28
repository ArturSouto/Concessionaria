
package com.concessionaria.controller;

import com.concessionaria.service.VeiculoService;
import com.concessionaria.model.Veiculo;
import java.util.Optional;

public class VeiculoController {{
    private VeiculoService service = new VeiculoService();

    public boolean create(Veiculo obj) {{
        return service.create(obj);
    }}

    public Optional<Veiculo> getById(int id) {{
        return service.findById(id);
    }}

    public boolean update(Veiculo obj) {{
        return service.update(obj);
    }}

    public boolean delete(int id) {{
        return service.delete(id);
    }}
}}

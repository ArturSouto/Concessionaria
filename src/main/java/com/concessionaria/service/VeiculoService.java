
package com.concessionaria.service;

import com.concessionaria.repository.VeiculoRepository;
import com.concessionaria.model.Veiculo;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class VeiculoService {{
    private VeiculoRepository repo = new VeiculoRepository();

    public boolean create(Veiculo obj) {{
        return repo.insert(obj);
    }}

    public Optional<Veiculo> findById(int id) {{
        return repo.findById(id);
    }}

    public boolean update(Veiculo obj) {{
        return repo.update(obj);
    }}

    public boolean delete(int id) {{
        return repo.delete(id);
    }}
}}

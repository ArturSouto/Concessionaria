
package com.concessionaria.service;

import com.concessionaria.repository.FuncionarioRepository;
import com.concessionaria.model.Funcionario;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioService {{
    private FuncionarioRepository repo = new FuncionarioRepository();

    public boolean create(Funcionario obj) {{
        return repo.insert(obj);
    }}

    public Optional<Funcionario> findById(String id) {{
        return repo.findById(id);
    }}

    public boolean update(Funcionario obj) {{
        return repo.update(obj);
    }}

    public boolean delete(String id) {{
        return repo.delete(id);
    }}
}}

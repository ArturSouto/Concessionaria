
package com.concessionaria.controller;

import com.concessionaria.service.FuncionarioService;
import com.concessionaria.model.Funcionario;
import java.util.Optional;

public class FuncionarioController {{
    private FuncionarioService service = new FuncionarioService();

    public boolean create(Funcionario obj) {{
        return service.create(obj);
    }}

    public Optional<Funcionario> getById(String id) {{
        return service.findById(id);
    }}

    public boolean update(Funcionario obj) {{
        return service.update(obj);
    }}

    public boolean delete(String id) {{
        return service.delete(id);
    }}
}}

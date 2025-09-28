
package com.concessionaria.controller;

import com.concessionaria.service.FornecedorService;
import com.concessionaria.model.Fornecedor;
import java.util.Optional;

public class FornecedorController {{
    private FornecedorService service = new FornecedorService();

    public boolean create(Fornecedor obj) {{
        return service.create(obj);
    }}

    public Optional<Fornecedor> getById(String id) {{
        return service.findById(id);
    }}

    public boolean update(Fornecedor obj) {{
        return service.update(obj);
    }}

    public boolean delete(String id) {{
        return service.delete(id);
    }}
}}

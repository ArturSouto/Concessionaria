
package com.concessionaria.service;

import com.concessionaria.repository.FornecedorRepository;
import com.concessionaria.model.Fornecedor;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class FornecedorService {{
    private FornecedorRepository repo = new FornecedorRepository();

    public boolean create(Fornecedor obj) {{
        return repo.insert(obj);
    }}

    public Optional<Fornecedor> findById(String id) {{
        return repo.findById(id);
    }}

    public boolean update(Fornecedor obj) {{
        return repo.update(obj);
    }}

    public boolean delete(String id) {{
        return repo.delete(id);
    }}
}}

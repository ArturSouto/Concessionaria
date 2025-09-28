
package com.concessionaria.service;

import com.concessionaria.repository.ClienteRepository;
import com.concessionaria.model.Cliente;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class ClienteService {{
    private ClienteRepository repo = new ClienteRepository();

    public boolean create(Cliente obj) {{
        return repo.insert(obj);
    }}

    public Optional<Cliente> findById(String id) {{
        return repo.findById(id);
    }}

    public boolean update(Cliente obj) {{
        return repo.update(obj);
    }}

    public boolean delete(String id) {{
        return repo.delete(id);
    }}
}}

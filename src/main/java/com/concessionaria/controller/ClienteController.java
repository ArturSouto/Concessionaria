
package com.concessionaria.controller;

import com.concessionaria.service.ClienteService;
import com.concessionaria.model.Cliente;
import java.util.Optional;

public class ClienteController {{
    private ClienteService service = new ClienteService();

    public boolean create(Cliente obj) {{
        return service.create(obj);
    }}

    public Optional<Cliente> getById(String id) {{
        return service.findById(id);
    }}

    public boolean update(Cliente obj) {{
        return service.update(obj);
    }}

    public boolean delete(String id) {{
        return service.delete(id);
    }}
}}

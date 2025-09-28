
package com.concessionaria.controller;

import com.concessionaria.service.PecasService;
import com.concessionaria.model.Pecas;
import java.util.Optional;

public class PecasController {{
    private PecasService service = new PecasService();

    public boolean create(Pecas obj) {{
        return service.create(obj);
    }}

    public Optional<Pecas> getById(String id) {{
        return service.findById(id);
    }}

    public boolean update(Pecas obj) {{
        return service.update(obj);
    }}

    public boolean delete(String id) {{
        return service.delete(id);
    }}
}}

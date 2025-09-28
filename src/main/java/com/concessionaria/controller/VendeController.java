
package com.concessionaria.controller;

import com.concessionaria.service.VendeService;
import com.concessionaria.model.Vende;
import java.util.Optional;

public class VendeController {{
    private VendeService service = new VendeService();

    public boolean create(Vende obj) {{
        return service.create(obj);
    }}

    public Optional<Vende> getById(String id) {{
        return service.findById(id);
    }}

    public boolean update(Vende obj) {{
        return service.update(obj);
    }}

    public boolean delete(String id) {{
        return service.delete(id);
    }}
}}

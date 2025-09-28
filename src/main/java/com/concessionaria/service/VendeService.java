
package com.concessionaria.service;

import com.concessionaria.repository.VendeRepository;
import com.concessionaria.model.Vende;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class VendeService {{
    private VendeRepository repo = new VendeRepository();

    public boolean create(Vende obj) {{
        return repo.insert(obj);
    }}

    public Optional<Vende> findById(String id) {{
        return repo.findById(id);
    }}

    public boolean update(Vende obj) {{
        return repo.update(obj);
    }}

    public boolean delete(String id) {{
        return repo.delete(id);
    }}
}}

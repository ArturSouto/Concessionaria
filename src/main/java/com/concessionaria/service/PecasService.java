
package com.concessionaria.service;

import com.concessionaria.repository.PecasRepository;
import com.concessionaria.model.Pecas;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class PecasService {{
    private PecasRepository repo = new PecasRepository();

    public boolean create(Pecas obj) {{
        return repo.insert(obj);
    }}

    public Optional<Pecas> findById(String id) {{
        return repo.findById(id);
    }}

    public boolean update(Pecas obj) {{
        return repo.update(obj);
    }}

    public boolean delete(String id) {{
        return repo.delete(id);
    }}
}}

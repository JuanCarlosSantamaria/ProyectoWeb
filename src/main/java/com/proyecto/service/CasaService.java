package com.proyecto.service;

import com.proyecto.domain.Casa;
import java.util.List;

public interface CasaService {

    public List<Casa> getCasas(boolean activo);

    public Casa getCasa(Casa casa);

    public void save(Casa casa);

    public void delete(Casa casa);

}

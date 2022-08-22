package com.proyecto.service;

import com.proyecto.domain.Acerca;
import java.util.List;

public interface AcercaService {

    public List<Acerca> getAcercas(boolean activo);

    public Acerca getAcerca(Acerca acerca);

    public void save(Acerca acerca);

    public void delete(Acerca acerca);

}

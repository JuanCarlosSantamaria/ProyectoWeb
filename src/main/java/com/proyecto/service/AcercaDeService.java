package com.proyecto.service;

import com.proyecto.domain.AcercaDe;
import java.util.List;

public interface AcercaDeService {

    public List<AcercaDe> getAcercaDes(boolean activo);

    public AcercaDe getAcercaDe(AcercaDe acercaDe);

    public void save(AcercaDe acercaDe);

    public void delete(AcercaDe acercaDe);

}

package com.proyecto.service;

import com.proyecto.domain.Cabana;
import java.util.List;

public interface CabanaService {

    public List<Cabana> getCabanas(boolean activo);

    public Cabana getCabana(Cabana cabana);

    public void save(Cabana cabana);

    public void delete(Cabana cabana);

}

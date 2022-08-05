package com.proyecto.service;

import com.proyecto.domain.Auto;
import java.util.List;

public interface AutoService {

    public List<Auto> getAutos(boolean activo);

    public Auto getAuto(Auto auto);

    public void save(Auto auto);

    public void delete(Auto auto);

}

package com.proyecto.service;

import com.proyecto.dao.CabanaDao;
import com.proyecto.domain.Cabana;
import com.proyecto.service.CabanaService;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CabanaServiceImpl implements CabanaService {

    @Autowired
    private CabanaDao cabanaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cabana> getCabanas(boolean activo) {
        var lista = (List<Cabana>) cabanaDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Cabana getCabana(Cabana cabana) {
        return cabanaDao.findById(cabana.getIdCabana()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Cabana cabana) {
        cabanaDao.save(cabana);
    }

    @Override
    @Transactional
    public void delete(Cabana cabana) {
        cabanaDao.delete(cabana);
    }
}

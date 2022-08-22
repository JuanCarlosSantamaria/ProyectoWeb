package com.proyecto.service;

import com.proyecto.dao.AcercaDao;
import com.proyecto.domain.Acerca;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcercaServiceImpl implements AcercaService {

    @Autowired
    private AcercaDao acercaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Acerca> getAcercas(boolean activo) {
        var lista = (List<Acerca>) acercaDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Acerca getAcerca(Acerca acerca) {
        return acercaDao.findById(acerca.getIdAcerca()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Acerca acerca) {
        acercaDao.save(acerca);
    }

    @Override
    @Transactional
    public void delete(Acerca acerca) {
        acercaDao.delete(acerca);
    }

}

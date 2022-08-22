package com.proyecto.service;

import com.proyecto.dao.CasaDao;
import com.proyecto.domain.Casa;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CasaServiceImpl implements CasaService {

    @Autowired
    private CasaDao casaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Casa> getCasas(boolean activo) {
        var lista = (List<Casa>) casaDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Casa getCasa(Casa casa) {
        return casaDao.findById(casa.getIdCasa()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Casa casa) {
        casaDao.save(casa);
    }

    @Override
    @Transactional
    public void delete(Casa casa) {
        casaDao.delete(casa);
    }

}

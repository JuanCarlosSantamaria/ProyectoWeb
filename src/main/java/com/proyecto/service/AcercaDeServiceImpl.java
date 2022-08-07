package com.proyecto.service;

import com.proyecto.dao.AcercaDeDao;
import com.proyecto.domain.AcercaDe;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcercaDeServiceImpl implements AcercaDeService {

    @Autowired
    private AcercaDeDao acercaDeDao;

    @Override
    @Transactional(readOnly = true)
    public List<AcercaDe> getAcercaDes(boolean activo) {
        var lista = (List<AcercaDe>) acercaDeDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public AcercaDe getAcercaDe(AcercaDe acercaDe) {
        return acercaDeDao.findById(acercaDe.getIdAcercaDe()).orElse(null);

    }

    @Override
    @Transactional
    public void save(AcercaDe acercaDe) {
        acercaDeDao.save(acercaDe);
    }

    @Override
    @Transactional
    public void delete(AcercaDe acercaDe) {
        acercaDeDao.delete(acercaDe);
    }

}

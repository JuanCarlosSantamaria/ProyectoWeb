package com.proyecto.service;

import com.proyecto.dao.AutoDao;
import com.proyecto.domain.Auto;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao autoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Auto> getAutos(boolean activo) {
        var lista = (List<Auto>) autoDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Auto getAuto(Auto auto) {
        return autoDao.findById(auto.getIdAuto()).orElse(null);

    }

    @Override
    @Transactional
    public void save(Auto auto) {
        autoDao.save(auto);
    }

    @Override
    @Transactional
    public void delete(Auto auto) {
        autoDao.delete(auto);
    }

}

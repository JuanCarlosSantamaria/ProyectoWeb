/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dao.AutosDao;
import com.proyecto.domain.Auto;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutosDao AutosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Auto> getAuto(boolean activo) {
        var lista = (List<Auto>) AutosDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

        @Override
        @Transactional(readOnly = true)
        public Autos getAutos(Auto Auto) {
        }        return AutosDao.findById(autos.getIdAuto()).orElse(null);

    }
}

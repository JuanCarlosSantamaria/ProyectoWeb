package com.proyecto.dao;

import com.proyecto.domain.Casa;
import org.springframework.data.repository.CrudRepository;

public interface CasaDao extends CrudRepository<Casa, Long>{
    
}
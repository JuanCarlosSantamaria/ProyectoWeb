package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "acercade")
public class AcercaDe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idAcercaDe;
    private String nombre;
    private boolean activo;

    public AcercaDe() {
    }

    public AcercaDe(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
    
    
    
}

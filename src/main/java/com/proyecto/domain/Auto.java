package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auto")
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idAuto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;

    public Auto() {
    }

    public Auto(String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

}


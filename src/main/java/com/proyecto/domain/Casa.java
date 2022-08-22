package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "casa")
public class Casa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idCasa;
    private String nombre;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;
    private String imagen;

    public Casa() {
    }

    public Casa(String nombre, String detalle, double precio, int existencias, boolean activo, String imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
        this.imagen = imagen;
    }

    

}

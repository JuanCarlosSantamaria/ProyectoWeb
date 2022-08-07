package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idCliente;
    private String nombre;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(String nombre, String detalle, double precio, int existencias, boolean activo) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    } 
}

package com.espe.micro_transaccion.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El número de transacción no debe estar vacío")
    @Column(nullable = false)
    private String numeroTransaccion;

    @NotEmpty(message = "El tipo no debe estar vacío")
    @Column(nullable = false)
    private String tipo;

    @NotNull(message = "El monto no debe estar vacío")
    @Column(nullable = false)
    private Integer monto;

    @NotNull(message = "La fecha de transacción no debe estar vacía")
    @Column(nullable = false)
    private Date fechaTransaccion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}

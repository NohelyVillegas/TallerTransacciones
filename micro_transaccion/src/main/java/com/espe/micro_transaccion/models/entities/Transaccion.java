package com.espe.micro_transaccion.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    @NotEmpty(message = "El número de transacción no puede estar vacío")
    private String numeroTransaccion;

    @Column(nullable=false)
    @NotEmpty(message = "El tipo no puede estar vacío")
    private String tipo;

    @Column(nullable=false)
    @NotNull(message = "El monto no puede ser nulo")
    private int monto;

    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de la transacción no puede ser nula")
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}

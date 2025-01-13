package com.espe.micro_transaccion.services;

import com.espe.micro_transaccion.models.entities.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    List<Transaccion> findAll();
    Optional<Transaccion> findById(Long id);
    Transaccion save(Transaccion transaccion);
    void deleteById(Long id);
}

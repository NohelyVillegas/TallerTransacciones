package com.espe.micro_transaccion.services;

import java.util.Optional;
import java.util.List;
import com.espe.micro_transaccion.models.entities.Transaccion;

public interface TransaccionService {

    List<Transaccion> findAll();
    Optional<Transaccion> findById(Long id);
    Transaccion save(Transaccion transaccion);
    void deleteById(Long id);
}

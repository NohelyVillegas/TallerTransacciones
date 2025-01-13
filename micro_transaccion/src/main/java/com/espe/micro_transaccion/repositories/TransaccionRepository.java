package com.espe.micro_transaccion.repositories;


import com.espe.micro_transaccion.models.entities.Transaccion;
import org.springframework.data.repository.CrudRepository;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
}

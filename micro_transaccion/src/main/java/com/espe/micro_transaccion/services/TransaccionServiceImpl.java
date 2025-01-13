package com.espe.micro_transaccion.services;

import com.espe.micro_transaccion.models.entities.Transaccion;
import com.espe.micro_transaccion.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    @Override
    public List<Transaccion> findAll() {
        return (List<Transaccion>) repository.findAll();
    }

    @Override
    public Optional<Transaccion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        return repository.save(transaccion);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

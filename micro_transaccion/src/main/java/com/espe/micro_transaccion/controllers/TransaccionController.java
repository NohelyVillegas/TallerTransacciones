package com.espe.micro_transaccion.controllers;

import com.espe.micro_transaccion.models.entities.Transaccion;
import com.espe.micro_transaccion.services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    // Crear una nueva transacción
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Transaccion transaccion, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(
                    err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccion));
    }

    // Listar todas las transacciones
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar una transacción por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Transaccion> transaccionOptional = service.findById(id);
        if (transaccionOptional.isPresent()) {
            return ResponseEntity.ok(transaccionOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Modificar una transacción por su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@RequestBody Transaccion transaccion, @PathVariable Long id) {
        Optional<Transaccion> transaccionOptional = service.findById(id);
        if (transaccionOptional.isPresent()) {
            Transaccion transaccionDB = transaccionOptional.get();
            transaccionDB.setNumeroTransaccion(transaccion.getNumeroTransaccion());
            transaccionDB.setTipo(transaccion.getTipo());
            transaccionDB.setMonto(transaccion.getMonto());
            transaccionDB.setFechaTransaccion(transaccion.getFechaTransaccion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccionDB));
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una transacción por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Transaccion> transaccionOptional = service.findById(id);
        if (transaccionOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

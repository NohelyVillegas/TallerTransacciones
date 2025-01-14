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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Transaccion transaccion, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccion));
    }

    @GetMapping
    public List<Transaccion> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Transaccion> optional = service.findById(id);
        return optional.isPresent()
                ? ResponseEntity.ok(optional.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Transaccion transaccion, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        Optional<Transaccion> optional = service.findById(id);
        if (optional.isPresent()) {
            Transaccion transaccionDB = optional.get();
            transaccionDB.setNumeroTransaccion(transaccion.getNumeroTransaccion());
            transaccionDB.setTipo(transaccion.getTipo());
            transaccionDB.setMonto(transaccion.getMonto());
            transaccionDB.setFechaTransaccion(transaccion.getFechaTransaccion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccionDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Transaccion> optional = service.findById(id);
        if (optional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

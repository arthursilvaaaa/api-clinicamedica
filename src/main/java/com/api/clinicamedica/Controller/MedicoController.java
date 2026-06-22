package com.api.clinicamedica.Controller;

import com.api.clinicamedica.Model.Medico;
import com.api.clinicamedica.Service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> list() {
        return ResponseEntity.ok(medicoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable long id) {
        return ResponseEntity.ok(medicoService.findById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<Medico> findByName(@RequestParam String nome) {
        return ResponseEntity.ok(medicoService.findByName(nome));
    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package com.api.clinicamedica.Controller;

import com.api.clinicamedica.Model.Paciente;
import com.api.clinicamedica.Service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> list() {
        return ResponseEntity.ok(pacienteService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable long id) {
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<Paciente> findByName(@RequestParam String nome) {
        return ResponseEntity.ok(pacienteService.findByName(nome));
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

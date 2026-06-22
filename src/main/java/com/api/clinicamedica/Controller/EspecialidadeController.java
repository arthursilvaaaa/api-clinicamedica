package com.api.clinicamedica.Controller;

import com.api.clinicamedica.Model.Especialidade;
import com.api.clinicamedica.Model.Paciente;
import com.api.clinicamedica.Service.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @GetMapping
    public ResponseEntity<List<Especialidade>> list() {
        return ResponseEntity.ok(especialidadeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> findById(@PathVariable long id) {
        return ResponseEntity.ok(especialidadeService.findById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<Especialidade> findByName(@RequestParam String nome) {
        return ResponseEntity.ok(especialidadeService.findByName(nome));
    }

    @PostMapping
    public ResponseEntity<Especialidade> save(@RequestBody Especialidade especialidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadeService.save(especialidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        especialidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


package com.api.clinicamedica.Controller;

import com.api.clinicamedica.Model.Consulta;
import com.api.clinicamedica.Service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> list() {
        return ResponseEntity.ok(consultaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findById(@PathVariable long id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Consulta> save(@RequestBody Consulta consulta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

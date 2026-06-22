package com.api.clinicamedica.Service;

import com.api.clinicamedica.Model.Consulta;
import com.api.clinicamedica.Repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public List<Consulta> listAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void delete(long id) {
        if (!consultaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }
        consultaRepository.deleteById(id);
    }
}


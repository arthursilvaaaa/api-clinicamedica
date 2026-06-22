package com.api.clinicamedica.Service;

import com.api.clinicamedica.Model.Medico;
import com.api.clinicamedica.Repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public List<Medico> listAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));
    }

    public Medico findByName(String nome) {
        return medicoRepository.findByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void delete(long id) {
        if (!medicoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }
        medicoRepository.deleteById(id);
    }
}
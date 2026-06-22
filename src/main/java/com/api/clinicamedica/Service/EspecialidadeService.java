package com.api.clinicamedica.Service;

import com.api.clinicamedica.Model.Especialidade;
import com.api.clinicamedica.Repository.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> listAll() {
        return especialidadeRepository.findAll();
    }

    public Especialidade findById(long id) {
        return especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada"));
    }

    public Especialidade findByName(String nome) {
        return especialidadeRepository.findByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada"));
    }

    public Especialidade save(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void delete(long id) {
        if (!especialidadeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada");
        }
        especialidadeRepository.deleteById(id);
    }
}

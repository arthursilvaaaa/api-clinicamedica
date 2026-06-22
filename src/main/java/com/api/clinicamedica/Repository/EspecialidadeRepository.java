package com.api.clinicamedica.Repository;

import com.api.clinicamedica.Model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Optional<Especialidade> findByNome(String nome);
}

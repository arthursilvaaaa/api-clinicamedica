package com.api.clinicamedica.Repository;

import com.api.clinicamedica.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNome(String nome);
}

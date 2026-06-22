package com.api.clinicamedica.Repository;

import com.api.clinicamedica.Model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}

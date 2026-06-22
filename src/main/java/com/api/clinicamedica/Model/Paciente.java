package com.api.clinicamedica.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consulta = new ArrayList<>();

    public Paciente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}

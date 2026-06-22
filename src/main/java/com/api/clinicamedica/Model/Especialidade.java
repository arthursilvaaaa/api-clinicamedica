package com.api.clinicamedica.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL)
    private List<Medico> medico = new ArrayList<>();

    public Especialidade(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.medico = new ArrayList<>();
    }
}

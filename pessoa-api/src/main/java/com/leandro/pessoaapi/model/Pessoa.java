package com.leandro.pessoaapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cpf;

    private String rg;

    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private String telefone;

    private String email;

}

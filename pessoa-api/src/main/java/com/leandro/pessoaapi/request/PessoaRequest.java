package com.leandro.pessoaapi.request;

import com.leandro.pessoaapi.model.EstadoCivil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

    private Long id;

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String cpf;

    private String rg;

    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    private String telefone;

    private String email;
}

package com.leandro.pessoaapi.repository;

import com.leandro.pessoaapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {

}

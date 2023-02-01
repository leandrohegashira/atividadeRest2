package com.leandro.pessoaapi.service;

import com.leandro.pessoaapi.model.Pessoa;
import com.leandro.pessoaapi.request.PessoaRequest;
import com.leandro.pessoaapi.response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    MessageResponse createPessoa(PessoaRequest pessoaRequest);

    Optional<Pessoa> update(Long pessoaId, PessoaRequest pessoaRequest);

    void delete(Long pessoaId);

    Pessoa getPessoa(Long pessoaId);

    List<Pessoa> getAll();



}

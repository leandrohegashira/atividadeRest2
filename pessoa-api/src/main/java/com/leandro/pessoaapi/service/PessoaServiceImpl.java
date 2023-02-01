package com.leandro.pessoaapi.service;

import com.leandro.pessoaapi.model.Pessoa;
import com.leandro.pessoaapi.repository.PessoaRepository;
import com.leandro.pessoaapi.request.PessoaRequest;
import com.leandro.pessoaapi.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public MessageResponse createPessoa(PessoaRequest pessoaRequest){

        Pessoa novaPessoa = new Pessoa();

        novaPessoa.setNome(pessoaRequest.getNome());
        novaPessoa.setEstadoCivil(pessoaRequest.getEstadoCivil());
        novaPessoa.setEmail(pessoaRequest.getEmail());
        novaPessoa.setTelefone(pessoaRequest.getTelefone());

        pessoaRepository.save(novaPessoa);

        return new MessageResponse("Nova pessoa cadastrada");
    }

    @Override
    public Optional<Pessoa> update(Long pessoaId, PessoaRequest pessoaRequest){

        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);

        if(pessoa.isEmpty()){
            throw new RuntimeException();
        } else {
            pessoa.get().setNome(pessoaRequest.getNome());
            pessoa.get().setEstadoCivil(pessoaRequest.getEstadoCivil());
            pessoa.get().setEmail(pessoaRequest.getEmail());
            pessoa.get().setTelefone(pessoaRequest.getTelefone());

            pessoaRepository.save(pessoa.get());
        }
        return pessoa;
    }

    @Override
    public Pessoa getPessoa(Long pessoaId){
        return pessoaRepository.findById(pessoaId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Pessoa> getAll(){
        return pessoaRepository.findAll();
    }

    @Override
    public void delete(Long pessoaId){

        if(pessoaRepository.getById(pessoaId).getId().equals(pessoaId)){
            pessoaRepository.deleteById(pessoaId);
        } else {
            throw new RuntimeException();
        }
    }
}

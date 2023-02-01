package com.leandro.pessoaapi.controller;

import com.leandro.pessoaapi.model.Pessoa;
import com.leandro.pessoaapi.request.PessoaRequest;
import com.leandro.pessoaapi.response.MessageResponse;
import com.leandro.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/all")
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = pessoaService.getAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable("pessoaid") Long id){
        Pessoa pessoa = pessoaService.getPessoa(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPessoa(@RequestBody PessoaRequest pessoa){
        MessageResponse novaPessoa = pessoaService.createPessoa(pessoa);
        return new ResponseEntity<>(novaPessoa, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public Optional<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody PessoaRequest pessoa){
        return pessoaService.update(id, pessoa);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

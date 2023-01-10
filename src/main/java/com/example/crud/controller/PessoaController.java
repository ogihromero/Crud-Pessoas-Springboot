package com.example.crud.controller;

import com.example.crud.entity.Pessoa;
import com.example.crud.repository.IPessoaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PessoaController {

    @Autowired
    IPessoaRepo pessoaRepo;

    @PostMapping("/pessoas")
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        try {
            return  new ResponseEntity<>(pessoaRepo.save(pessoa), HttpStatus.CREATED) ;
        } catch ( Exception e) {
           return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        try {
            List<Pessoa> list = pessoaRepo.findAll();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepo.findById(id);

        if (pessoa.isPresent()) {
            return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @PutMapping("/pessoas")
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaRepo.save(pessoa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<HttpStatus> deletePessoa(@PathVariable Long id) {
        try {
            Optional<Pessoa> pessoa = pessoaRepo.findById(id);
            if (pessoa.isPresent()) {
                pessoaRepo.delete(pessoa.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

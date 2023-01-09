package com.example.crud.controller;

import com.example.crud.entity.Pessoa;
import com.example.crud.repository.IPessoaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired
    IPessoaRepo pessoaRepo;

    @PostMapping("/pessoas")
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        try {
            return  new ResponseEntity<>(pessoaRepo.save(pessoa), HttpStatus.CREATED) ;
        } catch ( Exception e) {
           return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}

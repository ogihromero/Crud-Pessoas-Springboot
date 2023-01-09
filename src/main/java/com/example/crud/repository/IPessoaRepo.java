package com.example.crud.repository;

import com.example.crud.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaRepo extends JpaRepository<Pessoa, Long> {

}

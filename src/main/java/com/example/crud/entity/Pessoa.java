package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Table(name="pessoas")
@Entity
@Setter
@Getter
@ToString
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name="data_de_nascimento")
    private LocalDate dataDeNascimento;
    @Embedded
    private Endereco endereco;

}

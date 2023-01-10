package com.example.crud.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.intellij.lang.annotations.Pattern;

@Embeddable
@Setter
@Getter
@ToString
public class Endereco {

    @Pattern(value="\\d{5}-\\d{3}")
    private String cep;
    private String logradouro;
    private int numero;
    private String cidade;



}

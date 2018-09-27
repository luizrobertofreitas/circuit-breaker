package com.lizo.circuitbreaker.integration.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cep implements Serializable {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}

package com.lizo.circuitbreaker.controller;

import com.lizo.circuitbreaker.integration.CepIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("ceps")
public class CepController {

    private final CepIntegration cepIntegration;

    @Autowired
    public CepController(final CepIntegration cepIntegration) {
        this.cepIntegration = cepIntegration;
    }

    @GetMapping("/{cep}")
    public ResponseEntity getByCep(@PathVariable("cep")  final String cep) {
        log.info("Searching for cep: {}", cep);
        return ResponseEntity.ok(cepIntegration.get(cep));
    }

}

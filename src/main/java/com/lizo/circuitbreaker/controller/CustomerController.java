package com.lizo.circuitbreaker.controller;

import com.lizo.circuitbreaker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity all() {
        return ResponseEntity.ok(customerService.all());
    }

    @PostMapping("/init")
    public ResponseEntity init() {
        customerService.init();
        return ResponseEntity.noContent().build();
    }

}

package com.lizo.circuitbreaker.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}

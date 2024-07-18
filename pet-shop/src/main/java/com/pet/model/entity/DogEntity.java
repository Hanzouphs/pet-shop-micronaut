package com.pet.model.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
@Data
@Builder
@Introspected
@Serdeable.Deserializable
public class DogEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ToString.Include
    private String dogName;

    @ToString.Include
    private String dogBreed;

    @ToString.Include
    private String dogPort;

    @ToString.Include
    private Boolean castrated;
}

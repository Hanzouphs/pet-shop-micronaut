package com.pet.exceptions;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
 import java.util.Date;

@Getter
@AllArgsConstructor
@Serdeable.Serializable
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Date timestamp;
    private String message;
    private String details;
}

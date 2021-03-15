package com.alan.crud.exception;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;
}

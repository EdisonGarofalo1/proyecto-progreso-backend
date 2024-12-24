package com.multibranch.app.entities;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int code = 200;
    private String message;

}

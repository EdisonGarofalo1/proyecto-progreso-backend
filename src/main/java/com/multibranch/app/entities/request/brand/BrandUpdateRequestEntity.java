package com.multibranch.app.entities.request.brand;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BrandUpdateRequestEntity {
    private Integer idMarca ;
    private  String nombre;
}

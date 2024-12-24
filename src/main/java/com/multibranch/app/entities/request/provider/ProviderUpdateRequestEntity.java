package com.multibranch.app.entities.request.provider;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProviderUpdateRequestEntity {
    private Integer idProveedor ;
    private String ruc ;
    private String nombre ;
    private String razonSocial ;
    private String direccion ;
    private String telefono ;
    private String email;

}

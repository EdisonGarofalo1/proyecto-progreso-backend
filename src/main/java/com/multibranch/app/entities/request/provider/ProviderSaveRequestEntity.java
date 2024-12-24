package com.multibranch.app.entities.request.provider;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProviderSaveRequestEntity {
    private String ruc ;
    private String nombre ;
    private String razonSocial ;
    private String direccion ;
    private String telefono ;
    private String email;
}

package com.multibranch.app.entities.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateRequestEntity {
    private Integer idUsuario ;
    private String numeroIdentificacion  ;
    private String correoElectronico ;
    private String direccion;
    private String telefono ;
    private String username ;
    private String password ;
    private Integer rol;
    private Integer idSucursal;
}

package com.multibranch.app.entities.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class ClientUpdateRequestEntity {
  private Integer idCliente ;
  private String nombre ;
    private String direccion ;
    private String telefono_1 ;
    private String telefono_2  ;
    private String telefono_3  ;
    private String telefono_4  ;
    private String correo_electronico  ;
    private Integer limiteCredito  ;
    private String tipoIdentificacion ;
    private String numeroIdentificacion  ;
}

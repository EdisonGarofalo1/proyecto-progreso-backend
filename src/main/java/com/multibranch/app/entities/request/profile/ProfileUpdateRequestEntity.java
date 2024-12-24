package com.multibranch.app.entities.request.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProfileUpdateRequestEntity {

    private Integer idPerfil ;
    private String descripcion ;
}

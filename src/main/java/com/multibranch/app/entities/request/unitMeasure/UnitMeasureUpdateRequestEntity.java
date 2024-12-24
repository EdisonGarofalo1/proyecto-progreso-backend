package com.multibranch.app.entities.request.unitMeasure;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UnitMeasureUpdateRequestEntity {
    private Integer idUnidadMedida ;
    private String nombre ;
    private String nombreCorto ;
}

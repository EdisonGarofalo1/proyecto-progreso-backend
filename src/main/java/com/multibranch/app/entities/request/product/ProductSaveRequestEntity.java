package com.multibranch.app.entities.request.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductSaveRequestEntity {

    @NotNull(message = "La categoría es obligatoria")
    private Integer idCategoria;

    @NotNull(message = "La marca es obligatoria")
    private Integer idMarca;

    @NotNull(message = "La unidad de medida es obligatoria")
    private Integer idUnidadMedida;

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @NotEmpty(message = "La imagen es obligatoria")
    private String img;

    @NotNull(message = "Debe indicar si lleva IVA")
    private Integer llevaIva;

    @NotNull(message = "Debe indicar si es inventariable")
    private Integer inventariable;

    @NotNull(message = "Debe indicar si es perecedero")
    private Integer perecedero;



}

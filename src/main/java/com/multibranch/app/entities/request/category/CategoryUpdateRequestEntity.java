package com.multibranch.app.entities.request.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoryUpdateRequestEntity {

    @Min(value = 1, message = "El ID de la categoría debe ser mayor que 0")
     private int idCategoria;
    @NotBlank(message="El nombre es obligatorio")
    @Size(max =80 , message="El nombre no puede tener más de {max} caracteres")
    private String nombreCategoria;
}

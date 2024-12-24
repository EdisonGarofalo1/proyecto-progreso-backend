package com.multibranch.app.entities.request.category;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategorySaveRequestEntity {

    @Size(max =80 , message="El nombre no puede tener más de {max} caracteres")
    private String nombreCategoria;
}

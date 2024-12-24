package com.multibranch.app.entities.request.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class SaveProductLoteRequestEntity {
    @NotNull(message = "La sucursal es obligatoria")
    private Integer idSucursal;

    @NotNull(message = "El ID del producto es obligatorio")
    private Integer id_producto;

    @Size(max = 50, message = "El código de barra no puede superar los 50 caracteres")
    private String codigo_barra;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha de vencimiento debe tener el formato yyyy-MM-dd")
    private String fecha_vencimiento;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;

    @NotNull(message = "El precio de venta es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de venta debe ser mayor que 0")
    private BigDecimal precio_venta;

    @NotNull(message = "El precio de compra es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de compra debe ser mayor que 0")
    private BigDecimal precio_compra;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio 1 debe ser mayor que 0")
    private BigDecimal precio_1;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio 2 debe ser mayor que 0")
    private BigDecimal precio_2;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Integer id_usuario;

    @Size(max = 255, message = "El concepto no puede superar los 255 caracteres")
    private String concepto;
}

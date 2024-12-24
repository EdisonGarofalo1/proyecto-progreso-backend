package com.multibranch.app.entities.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@Data
public class OrderSaveRequestEntity {
    private Integer idCliente;
    private Integer idUsuario;
    private Integer idSucursal;
    private BigDecimal iva;
    private BigDecimal subtotal;
    private BigDecimal total;
    private List<OrderSaveProductRequestEntity> detalles;
}

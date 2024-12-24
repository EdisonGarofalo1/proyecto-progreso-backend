package com.multibranch.app.entities.request.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
public class OrderSaveProductRequestEntity {
    private Integer idPedido;
    private Integer idProducto;
    private Integer idLote;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal iva;
    private BigDecimal subTotal;
    private BigDecimal total;


}

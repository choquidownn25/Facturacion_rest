package org.exemple.data;

import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FacturaTotalSubTotalDTO {
    private Integer facturaId;
    private Date facturaFecha;
    private Integer clienteId;
    private String clienteNombre;
    private Integer productoId;
    private String productoDescripcion;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;
    private Double subtotalTotal;
    private Double totalTotal;
}

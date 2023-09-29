package org.exemple.data;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DetallefacturaDTO {

    private Integer id;
    private ProductoDTO producto;
    private FacturaDTO factura;
    private Double precio;
    private Integer cantidad;

}
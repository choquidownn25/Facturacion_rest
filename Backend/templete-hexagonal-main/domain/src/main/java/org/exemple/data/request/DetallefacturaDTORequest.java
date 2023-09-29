package org.exemple.data.request;

import lombok.*;
import org.exemple.data.FacturaDTO;
import org.exemple.data.ProductoDTO;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DetallefacturaDTORequest {

    private Integer id;
    private FacturaDTO factura;
    private ProductoDTO producto;
    private Double precio;
    private Integer cantidad;



}
package org.exemple.data.request;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ProductoDTORequest {

    private Integer id;
    private Integer cantidad;
    private String descripcion;
    private String imagen;
    private String nombre;
    private Double precio;

}
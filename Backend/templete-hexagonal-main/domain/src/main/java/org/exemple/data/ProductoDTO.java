package org.exemple.data;

import lombok.*;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ProductoDTO {

    private Integer id;
    private Integer cantidad;
    private String descripcion;
    private String imagen;
    private String nombre;
    private Double precio;

}
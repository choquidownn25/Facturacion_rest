package org.exemple.data;

import lombok.*;

import java.util.Set;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String telefono;
    private String mail;
    private String direccion;
}
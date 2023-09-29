package org.exemple.data.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTORequest {

    private Integer id;
    private String nombre;
    private String telefono;
    private String mail;
    private String direccion;


}
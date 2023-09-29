package org.exemple.data.request;

import lombok.*;
import org.exemple.data.ClienteDTO;

import java.time.LocalDate;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FacturaDTORequest {

    private Integer id;
    private LocalDate fecha;
    private ClienteDTO cliente;
}
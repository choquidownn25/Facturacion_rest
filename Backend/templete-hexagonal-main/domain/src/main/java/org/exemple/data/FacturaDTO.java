package org.exemple.data;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FacturaDTO {
    private Integer id;
    private LocalDate fecha;
    private Date fechacreate;
    private ClienteDTO cliente;
}
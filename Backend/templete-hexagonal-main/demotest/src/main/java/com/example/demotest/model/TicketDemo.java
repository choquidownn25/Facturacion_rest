package com.example.demotest.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
@Jacksonized

public class TicketDemo {
    private Integer id;
    private String usuario;
    private String fechaCreacion;
    private String fechaActualizacion;
    private Integer estatus;
}

package com.example.demotest.model;



import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;


@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
@Jacksonized
@Entity
@Table(name = "ticket")
public class TicketDemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;
    @Column(name = "fecha_actualizacion", nullable = false)
    private String fechaActualizacion;
    @Column(name = "estatus", nullable = false)
    private Integer estatus;
}

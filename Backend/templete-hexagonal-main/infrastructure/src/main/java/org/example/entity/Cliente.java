package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "mail", length = 70)
    private String mail;

    @Column(name = "direccion", length = 70)
    private String direccion;

}
package com.Me.APIRestForo.Domain.Perfiles;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;

    public Perfil(DatosRegistrarPerfil datosRegistrarPerfil) {
        this.nombre = datosRegistrarPerfil.nombre();
    }
}

package com.Me.APIRestForo.Domain.Cursos;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;

    public Curso(DatosRegistrarCursos datosRegistrarCursos) {
        this.nombre = datosRegistrarCursos.nombre();
    }
}

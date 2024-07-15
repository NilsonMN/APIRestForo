package com.Me.APIRestForo.Domain.Cursos;

public record DatosListadoCursos(
        Long id,
        String nombre
) {
    public DatosListadoCursos(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre()
        );
    }
}

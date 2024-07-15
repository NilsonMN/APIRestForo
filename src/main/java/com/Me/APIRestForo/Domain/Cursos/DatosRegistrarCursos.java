package com.Me.APIRestForo.Domain.Cursos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarCursos(
        @NotBlank
        String nombre
) {
}

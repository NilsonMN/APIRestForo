package com.Me.APIRestForo.Domain.Topico;

import jakarta.validation.constraints.NotNull;

public record DatosPublicarTopico(
        @NotNull
        Long id,
        @NotNull
        Long IDperfil,
        @NotNull
        Long IDcurso,
        @NotNull
        String mensaje,
        @NotNull
        String nombreCurso,
        @NotNull
        String titulo
) {
}

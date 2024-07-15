package com.Me.APIRestForo.Domain.Topico;

import jakarta.validation.constraints.NotNull;

public record DatosTopicoActualizado(
        @NotNull
        Long id,
        String titulo,
        String mensaje
) {
}

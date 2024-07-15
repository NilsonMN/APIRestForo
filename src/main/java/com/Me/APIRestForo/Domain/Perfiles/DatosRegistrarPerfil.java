package com.Me.APIRestForo.Domain.Perfiles;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarPerfil(
        @NotBlank
        String nombre
) {
}

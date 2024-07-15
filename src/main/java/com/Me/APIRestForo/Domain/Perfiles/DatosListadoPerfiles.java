package com.Me.APIRestForo.Domain.Perfiles;

public record DatosListadoPerfiles(
        Long id,
        String nombre
) {

    public DatosListadoPerfiles(Perfil perfil) {
        this(
                perfil.getId(),
                perfil.getNombre()
        );
    }
}

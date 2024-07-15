package com.Me.APIRestForo.Domain.Topico;

import java.time.LocalDateTime;

public record DatosDetallePublicacion(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha) {
    public DatosDetallePublicacion(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha()
        );
    }
}

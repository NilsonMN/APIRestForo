package com.Me.APIRestForo.Domain.Topico;

import com.Me.APIRestForo.Domain.Cursos.Curso;
import com.Me.APIRestForo.Domain.Perfiles.Perfil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    private LocalDateTime fecha;

    public void actualizarDatos(DatosTopicoActualizado datosTopicoActualizado) {
        if (datosTopicoActualizado.titulo() != null) {
            this.titulo = datosTopicoActualizado.titulo();
        }
        if (datosTopicoActualizado.mensaje() != null) {
            this.mensaje = datosTopicoActualizado.mensaje();
        }
    }
}

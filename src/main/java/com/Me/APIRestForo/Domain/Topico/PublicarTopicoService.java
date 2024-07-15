package com.Me.APIRestForo.Domain.Topico;

import com.Me.APIRestForo.Domain.Cursos.CursoRepository;
import com.Me.APIRestForo.Domain.Perfiles.PerfilRespository;
import com.Me.APIRestForo.Infra.Errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PublicarTopicoService {

    @Autowired
    private PerfilRespository perfilRespository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetallePublicacion publicar(DatosPublicarTopico datos) {

        if (!perfilRespository.findById(datos.IDperfil()).isPresent()) {
            throw new ValidacionDeIntegridad("este ID de usuario no existe");
        }

        if (!cursoRepository.findById(datos.IDcurso()).isPresent()) {
            throw new ValidacionDeIntegridad("este ID de curso no existe");
        }

        LocalDateTime fechaHoraActual = LocalDateTime.now();

        var perfil = perfilRespository.findById(datos.IDperfil()).get();
        var curso = cursoRepository.findById(datos.IDcurso()).get();

        var topico = new Topico(
                datos.id(),
                datos.titulo(),
                datos.mensaje(),
                perfil,
                curso,
                fechaHoraActual);

        topicoRepository.save(topico);

        return new DatosDetallePublicacion(topico);
    }
}

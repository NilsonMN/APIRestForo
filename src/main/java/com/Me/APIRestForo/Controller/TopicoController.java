package com.Me.APIRestForo.Controller;

import com.Me.APIRestForo.Domain.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private PublicarTopicoService service;

    @Autowired
    private TopicoRepository repository;

    //listar
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(
            page = 0, size = 4) Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable)
                .map(DatosListadoTopicos::new));
    }

    //registrar
    @PostMapping
    public ResponseEntity publicarTopico(@RequestBody @Valid DatosPublicarTopico datos) {
        var response = service.publicar(datos);

        return ResponseEntity.ok(response);
    }

    //listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);

        var datosTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha());
        return ResponseEntity.ok(datosTopico);
    }

    //borrar de la base de datos
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {

        Topico topico = repository.getReferenceById(id);
        repository.delete(topico);

        return null;
    }

    //actualizar topico
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosTopicoActualizado datosTopicoActualizado) {
        Topico topico = repository.getReferenceById(datosTopicoActualizado.id());

        topico.actualizarDatos(datosTopicoActualizado);

        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha()
        ));
    }
}

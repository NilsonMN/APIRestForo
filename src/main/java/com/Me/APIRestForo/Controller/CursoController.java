package com.Me.APIRestForo.Controller;

import com.Me.APIRestForo.Domain.Cursos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    //listar
    @GetMapping
    private ResponseEntity<Page<DatosListadoCursos>> listadoCursos(@PageableDefault(page = 0, size = 4) Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion)
                .map(DatosListadoCursos::new));
    }

    //registar Curso
    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(@RequestBody @Valid DatosRegistrarCursos datosRegistrarCursos,
                                                              UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = repository.save(new Curso(datosRegistrarCursos));

        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(curso.getId(), curso.getNombre());

        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }
}

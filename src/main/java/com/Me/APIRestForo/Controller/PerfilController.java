package com.Me.APIRestForo.Controller;

import com.Me.APIRestForo.Domain.Perfiles.*;
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
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilRespository repository;

    //listar
    @GetMapping
    public ResponseEntity<Page<DatosListadoPerfiles>> listadoPerfiles(@PageableDefault(page = 0, size = 4) Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion)
                .map(DatosListadoPerfiles::new));
    }

    //registrar Perfil
    @PostMapping
    public ResponseEntity<DatosRespuestaPerfil> registrarPerfil(@RequestBody @Valid DatosRegistrarPerfil datosRegistrarPerfil,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Perfil perfil = repository.save(new Perfil(datosRegistrarPerfil));

        DatosRespuestaPerfil datosRespuestaPerfil = new DatosRespuestaPerfil(perfil.getId(),
                perfil.getNombre());
        URI url = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaPerfil);
    }
}

//<dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-security</artifactId>
//		</dependency>
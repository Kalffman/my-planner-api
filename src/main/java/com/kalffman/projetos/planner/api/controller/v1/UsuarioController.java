package com.kalffman.projetos.planner.api.controller.v1;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioDTO;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.domain.entity.Usuario;
import com.kalffman.projetos.planner.domain.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<?> registrar(@RequestBody @Valid NovoUsuarioDTO dto) {
        UsuarioSimpleDTO simpleDTO = service.novoUsuario(dto);

        return ResponseEntity.created(simpleDTO.location()).body(simpleDTO);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getByID(@PathVariable Long id) {
        UsuarioSimpleDTO simpleDTO = service.getById(id);

        return ResponseEntity.created(simpleDTO.location()).body(simpleDTO);
    }
}

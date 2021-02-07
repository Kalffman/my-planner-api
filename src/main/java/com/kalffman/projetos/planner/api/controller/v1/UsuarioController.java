package com.kalffman.projetos.planner.api.controller.v1;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioDTO;
import com.kalffman.projetos.planner.api.dto.NovoUsuarioTelegramDTO;
import com.kalffman.projetos.planner.api.dto.ResourceModel;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.domain.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1/usuarios")
@Slf4j
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<?> registrar(@RequestBody @Valid NovoUsuarioDTO dto) {
        UsuarioSimpleDTO simpleDTO = service.novoUsuario(dto);

        buildLinks(simpleDTO);

        return new ResponseEntity<>(simpleDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/registrar/telegram", produces = "application/json")
    public ResponseEntity<?> registrarTelegram(@RequestBody @Valid NovoUsuarioTelegramDTO dto) {
        UsuarioSimpleDTO simpleDTO = service.novoUsuario(dto);

        buildLinks(simpleDTO);

        return new ResponseEntity<>(simpleDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getByID(@PathVariable Long id) {
        UsuarioSimpleDTO simpleDTO = service.getById(id);

        buildLinks(simpleDTO);

        return new ResponseEntity<>(simpleDTO, HttpStatus.OK);
    }

    private void buildLinks(ResourceModel<?> resourceModel) {
        final WebMvcLinkBuilder self = linkTo(methodOn(UsuarioController.class).getByID(resourceModel.identifier()));
        resourceModel.add(self.withSelfRel());
    }
}

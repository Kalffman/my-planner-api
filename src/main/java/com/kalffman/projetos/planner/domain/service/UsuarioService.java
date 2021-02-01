package com.kalffman.projetos.planner.domain.service;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioDTO;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.domain.entity.Usuario;
import com.kalffman.projetos.planner.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper mapper;

    public UsuarioService(UsuarioRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UsuarioSimpleDTO novoUsuario(NovoUsuarioDTO dto) {
        Usuario novoUsuario = mapper.map(dto, Usuario.class);

        Usuario usuarioCriado = repository.save(novoUsuario);

        return mapper.map(usuarioCriado, UsuarioSimpleDTO.class);
    }

    public UsuarioSimpleDTO getById(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        return mapper.map(usuario, UsuarioSimpleDTO.class);
    }
}

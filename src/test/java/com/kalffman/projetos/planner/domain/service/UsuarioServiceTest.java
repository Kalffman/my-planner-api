package com.kalffman.projetos.planner.domain.service;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioDTO;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.core.mapper.MapperConfig;
import com.kalffman.projetos.planner.domain.entity.Usuario;
import com.kalffman.projetos.planner.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void init() {
        usuarioRepository = mock(UsuarioRepository.class);
        ModelMapper mapper = new MapperConfig().modelMapper();
        usuarioService = new UsuarioService(usuarioRepository, mapper);
    }

    @Test
    public void deve_retornar_UsuarioSimpleDTO_ao_criar_novo_usuario() {
        NovoUsuarioDTO resultadoEsperado = novoUsuarioDTOEsperado();

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioGeradoFake());

        UsuarioSimpleDTO resultadoGerado = usuarioService.novoUsuario(novoUsuarioDTOFake());

        assertNotNull(resultadoGerado);
        assertEquals(resultadoEsperado.getNome(), resultadoGerado.getNome());
        assertEquals(resultadoEsperado.getEmail(), resultadoGerado.getEmail());
        assertEquals(resultadoEsperado.getSenha(), resultadoGerado.getSenhaEncriptada());
    }


    private NovoUsuarioDTO novoUsuarioDTOFake() {
        return novoUsuarioDTOEsperado();
    }

    private NovoUsuarioDTO novoUsuarioDTOEsperado() {
        NovoUsuarioDTO dto = new NovoUsuarioDTO();

        dto.setNome("Joaquim");
        dto.setEmail("joaquim@gmail.com");
        dto.setSenha("53nh41nqu38rv3l");

        return dto;
    }

    private Usuario usuarioGeradoFake() {
        Usuario u = new Usuario();
        u.setId(1L);
        u.setNome("Joaquim");
        u.setSenha("53nh41nqu38rv3l");
        u.setEmail("joaquim@gmail.com");
        u.setDataHoraCriacao(LocalDateTime.now());
        return u;
    }

    @Test
    public void deve_retornar_UsuarioSimpleDTO_buscar_pelo_id() {
        UsuarioSimpleDTO resultadoEsperado = usuarioSimpleDTOComID();
        Long meninoNey = 10L;

        when(usuarioRepository.findById(any(Long.class))).thenReturn(usuarioComIDOptionalFake());

        UsuarioSimpleDTO resultadoGerado = usuarioService.getById(meninoNey);

        assertNotNull(resultadoGerado);
        assertEquals(resultadoEsperado.getId(), resultadoGerado.getId());
        assertEquals(resultadoEsperado.getNome(), resultadoGerado.getNome());
        assertEquals(resultadoEsperado.getEmail(), resultadoGerado.getEmail());
        assertEquals(resultadoEsperado.getSenhaEncriptada(), resultadoGerado.getSenhaEncriptada());
    }

    private UsuarioSimpleDTO usuarioSimpleDTOComID() {
        UsuarioSimpleDTO dto = new UsuarioSimpleDTO();

        dto.setId(10L);
        dto.setNome("Neymar da Silva Santos Júnior");
        dto.setEmail("menino_ney@psg.com");
        dto.setSenhaEncriptada("njun10r");

        return dto;
    }

    private Optional<Usuario> usuarioComIDOptionalFake() {
        Usuario usuario = new Usuario();

        usuario.setId(10L);
        usuario.setNome("Neymar da Silva Santos Júnior");
        usuario.setEmail("menino_ney@psg.com");
        usuario.setSenha("njun10r");
        usuario.setDataHoraCriacao(LocalDateTime.now());

        return Optional.of(usuario);
    }
}

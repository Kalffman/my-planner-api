package com.kalffman.projetos.planner.api.controller.v1;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioDTO;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.domain.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    private UsuarioService usuarioService;
    private UsuarioController usuarioController;

    @BeforeEach
    public void init() {
        usuarioService = mock(UsuarioService.class);
        usuarioController = new UsuarioController(usuarioService);
    }

    @Test
    public void deve_garantir_retorno_de_novo_usuario_com_href() {
        NovoUsuarioDTO resultadoEsperado = novoUsuarioDTOEsperado();

        when(usuarioService.novoUsuario(any(NovoUsuarioDTO.class))).thenReturn(usuarioSimpleDTOCriadoFake());

        ResponseEntity<?> resultadoGerado = usuarioController.registrar(novoUsuarioDTOFake());

        assertNotNull(resultadoGerado.getBody());
        assertEquals(UsuarioSimpleDTO.class, resultadoGerado.getBody().getClass());

        UsuarioSimpleDTO bodyGerado = (UsuarioSimpleDTO) resultadoGerado.getBody();

        assertEquals(resultadoEsperado.getNome(), bodyGerado.getNome());
        assertEquals(resultadoEsperado.getEmail(), bodyGerado.getEmail());
        assertEquals(resultadoEsperado.getSenha(), bodyGerado.getSenhaEncriptada());
        assertEquals(10L, bodyGerado.getId());
        assertEquals("/v1/usuarios/10", requireNonNull(bodyGerado.getLink("self").orElse(null)).getHref());
    }

    private NovoUsuarioDTO novoUsuarioDTOEsperado() {
        return novoUsuarioDTOFake();
    }

    private NovoUsuarioDTO novoUsuarioDTOFake() {
        NovoUsuarioDTO dto = new NovoUsuarioDTO();
        dto.setNome("Lionel Messi");
        dto.setEmail("memessi_maranhense@gmail.com");
        dto.setSenha("p41t4x4t0");
        return dto;
    }

    private UsuarioSimpleDTO usuarioSimpleDTOCriadoFake() {
        UsuarioSimpleDTO dto = new UsuarioSimpleDTO();
        dto.setId(10L);
        dto.setNome("Lionel Messi");
        dto.setEmail("memessi_maranhense@gmail.com");
        dto.setSenhaEncriptada("p41t4x4t0");
        return dto;
    }

    @Test
    public void deve_garantir_retorno_da_busca_de_usuario_por_id() {
        UsuarioSimpleDTO resultadoEsperado = usuarioSimpleDTOComIDEsperado();
        Long craque = 7L;

        when(usuarioService.getById(craque)).thenReturn(usuarioSimpleDTOComIDFake());

        ResponseEntity<?> resultadoGerado = usuarioController.getByID(craque);

        assertNotNull(resultadoGerado.getBody());
        assertEquals(UsuarioSimpleDTO.class, resultadoGerado.getBody().getClass());

        UsuarioSimpleDTO bodyGerado = (UsuarioSimpleDTO) resultadoGerado.getBody();

        assertEquals(resultadoEsperado.getNome(), bodyGerado.getNome());
        assertEquals(resultadoEsperado.getEmail(), bodyGerado.getEmail());
        assertEquals(resultadoEsperado.getSenhaEncriptada(), bodyGerado.getSenhaEncriptada());
        assertEquals(craque, bodyGerado.getId());
        assertEquals("/v1/usuarios/" + craque, requireNonNull(bodyGerado.getLink("self").orElse(null)).getHref());
    }

    private UsuarioSimpleDTO usuarioSimpleDTOComIDEsperado() {
        return usuarioSimpleDTOComIDFake();
    }

    private UsuarioSimpleDTO usuarioSimpleDTOComIDFake() {
        UsuarioSimpleDTO dto = new UsuarioSimpleDTO();
        dto.setId(7L);
        dto.setNome("Cristiano Ronaldo");
        dto.setEmail("cristian.ta.on@gmail.com");
        dto.setSenhaEncriptada("f4l4m3n05");
        return dto;
    }
}

package com.kalffman.projetos.planner.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.net.URI;

@Data
public class UsuarioSimpleDTO {
    private Long id;
    private String nome;
    private String email;
    private String senhaEncriptada;

    @JsonIgnore
    public URI location() {
        return URI.create("/v1/usuarios/" + id);
    }
}

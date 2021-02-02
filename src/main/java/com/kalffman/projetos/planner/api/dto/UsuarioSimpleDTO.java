package com.kalffman.projetos.planner.api.dto;

import lombok.Data;

@Data
public class UsuarioSimpleDTO extends ResourceModel<UsuarioSimpleDTO> {
    private Long id;
    private String nome;
    private String email;
    private String senhaEncriptada;

    @Override
    public Long identifier() {
        return id;
    }
}

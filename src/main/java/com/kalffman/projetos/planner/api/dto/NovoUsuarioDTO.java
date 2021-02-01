package com.kalffman.projetos.planner.api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class NovoUsuarioDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String senha;
}

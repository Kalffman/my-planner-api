package com.kalffman.projetos.planner.api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class NovoUsuarioTelegramDTO {
    @NotNull
    private Long chatId;
    @NotEmpty
    private String usuarioTelegram;
    private String primeiroNome;
    private String sobrenome;
    private String nomeCompleto;
    private String apelido;
}

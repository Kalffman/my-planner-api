package com.kalffman.projetos.planner.domain.entity.plugin;

import com.kalffman.projetos.planner.domain.entity.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(schema = "plugin", name = "chat_telegram")
public class ChatTelegram {

    @Id
    @Column(name = "chat_id")
    private Long id;

    @NotEmpty
    @Column(name = "usuario_telegram", unique = true)
    private String usuarioTelegram;

    @Column(name = "usuario_primeiro_nome")
    private String usuarioPrimeiroNome;

    @Column(name = "usuario_sobrenome")
    private String usuarioSobrenome;

    @Column(name = "usuario_nome_completo")
    private String usuarioNomeCompleto;

    @Column(name = "usuario_apelido")
    private String usuarioApelido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_planner_id")
    private Usuario usuarioPlanner;
}

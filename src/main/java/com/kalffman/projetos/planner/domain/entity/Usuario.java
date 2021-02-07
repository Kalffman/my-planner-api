package com.kalffman.projetos.planner.domain.entity;

import com.kalffman.projetos.planner.domain.entity.plugin.ChatTelegram;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(schema = "planner", name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_hora_criacao", insertable = false, updatable = false, columnDefinition = "timestamp default 'now()'")
    private LocalDateTime dataHoraCriacao;

    @OneToMany(mappedBy = "usuarioPlanner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ChatTelegram> chatTelegramList;

    public void addChatTelegram(ChatTelegram chat) {
        if(chatTelegramList == null){
            chatTelegramList = new ArrayList<>();
        }
        chat.setUsuarioPlanner(this);
        chatTelegramList.add(chat);
    }
}

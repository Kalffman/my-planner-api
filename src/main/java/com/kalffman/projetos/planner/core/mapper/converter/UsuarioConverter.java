package com.kalffman.projetos.planner.core.mapper.converter;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioTelegramDTO;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.domain.entity.Usuario;
import com.kalffman.projetos.planner.domain.entity.plugin.ChatTelegram;
import org.modelmapper.Converter;

public class UsuarioConverter {

    public static Converter<Usuario, UsuarioSimpleDTO> toUsuarioSimpleDTO() {
        return context -> {
            Usuario source = context.getSource();
            if (source == null) return null;

            UsuarioSimpleDTO dto = new UsuarioSimpleDTO();

            dto.setId(source.getId());
            dto.setSenhaEncriptada(source.getSenha());
            dto.setNome(source.getNome());
            dto.setEmail(source.getEmail());

            return dto;
        };
    }

    public static Converter<NovoUsuarioTelegramDTO, Usuario> fromNovoUsuarioTelegramDTO() {
        return context -> {
            NovoUsuarioTelegramDTO source = context.getSource();
            if (source == null) return null;

            ChatTelegram chat = new ChatTelegram();

            chat.setId(source.getChatId());
            chat.setUsuarioTelegram(source.getUsuarioTelegram());
            chat.setUsuarioPrimeiroNome(source.getPrimeiroNome());
            chat.setUsuarioSobrenome(source.getSobrenome());
            chat.setUsuarioNomeCompleto(source.getNomeCompleto());
            chat.setUsuarioApelido(source.getApelido());

            Usuario usuario = new Usuario();
            usuario.setNome(source.getNomeCompleto());
            usuario.addChatTelegram(chat);

            return usuario;
        };
    }
}

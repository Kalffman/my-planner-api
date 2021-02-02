package com.kalffman.projetos.planner.core.mapper.converter;

import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.domain.entity.Usuario;
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
}

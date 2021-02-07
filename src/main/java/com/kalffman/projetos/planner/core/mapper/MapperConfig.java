package com.kalffman.projetos.planner.core.mapper;

import com.kalffman.projetos.planner.api.dto.NovoUsuarioTelegramDTO;
import com.kalffman.projetos.planner.api.dto.UsuarioSimpleDTO;
import com.kalffman.projetos.planner.core.mapper.converter.UsuarioConverter;
import com.kalffman.projetos.planner.domain.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MapperConfig {

    @Bean
    @Scope("prototype")
    public ModelMapper modelMapper() {
        ModelMapper mp = new ModelMapper();

        mp.addConverter(UsuarioConverter.toUsuarioSimpleDTO(), Usuario.class, UsuarioSimpleDTO.class);
        mp.addConverter(UsuarioConverter.fromNovoUsuarioTelegramDTO(), NovoUsuarioTelegramDTO.class, Usuario.class);

        return mp;
    }


}

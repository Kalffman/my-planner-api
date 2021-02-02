package com.kalffman.projetos.planner.core.mapper;

import com.kalffman.projetos.planner.core.mapper.converter.UsuarioConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mp = new ModelMapper();

        mp.addConverter(UsuarioConverter.toUsuarioSimpleDTO());

        return mp;
    }


}

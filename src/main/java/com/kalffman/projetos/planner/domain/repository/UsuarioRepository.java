package com.kalffman.projetos.planner.domain.repository;

import com.kalffman.projetos.planner.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

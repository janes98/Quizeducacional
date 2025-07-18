package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janequiz.quizeducacional.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

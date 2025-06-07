package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janequiz.quizeducacional.entities.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Long > {

}

package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janequiz.quizeducacional.entities.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

}

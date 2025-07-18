package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.janequiz.quizeducacional.entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
}


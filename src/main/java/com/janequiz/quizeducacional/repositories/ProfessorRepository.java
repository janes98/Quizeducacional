package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janequiz.quizeducacional.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}

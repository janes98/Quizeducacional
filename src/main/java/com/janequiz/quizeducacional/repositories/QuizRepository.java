package com.janequiz.quizeducacional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janequiz.quizeducacional.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	

}

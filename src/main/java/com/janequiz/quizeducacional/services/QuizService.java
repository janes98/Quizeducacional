package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Quiz;
import com.janequiz.quizeducacional.repositories.QuizRepository;

@Service
public class QuizService {

	private final QuizRepository quizRepository;

	public QuizService(QuizRepository quizRepository) {

		this.quizRepository = quizRepository;

	}

	public List<Quiz> listarTodos() {
		return quizRepository.findAll();

	}

	public Optional<Quiz> buscarPorId(Long id) {
		return quizRepository.findById(id);

	}

	public Quiz salvar(Quiz quiz) {
		return quizRepository.save(quiz);

	}

	public void deletar(Long id) {
		quizRepository.deleteById(id);

	}

}

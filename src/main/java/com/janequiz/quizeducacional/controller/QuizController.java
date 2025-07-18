package com.janequiz.quizeducacional.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janequiz.quizeducacional.entities.Quiz;
import com.janequiz.quizeducacional.services.QuizService;
import com.janequiz.quizeducacional.dto.QuizDTO;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
	
	private final QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
		
	}
	
	@GetMapping
	public List<QuizDTO> listarTodos() {
		return quizService.listarTodos()
				       .stream()
				       .map(QuizDTO::new)
				       .toList();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<QuizDTO> buscarPorId(@PathVariable Long id) {
		return quizService.buscarPorId(id)
				.map(quiz -> ResponseEntity.ok(new QuizDTO(quiz)))
			    .orElseGet(() -> ResponseEntity.notFound().build());
		
		
	}
	
	@PostMapping
	public QuizDTO criar(@RequestBody Quiz quiz) {
		Quiz salvo = quizService.salvar(quiz);
		return new QuizDTO(salvo);
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Quiz> atualizar(@PathVariable Long id, @RequestBody Quiz quizAtualizado) {
		
		if(quizService.buscarPorId(id).isPresent()) {
			quizAtualizado.setId(id);
			return ResponseEntity.ok(quizService.salvar(quizAtualizado));
			
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		if(quizService.buscarPorId(id).isPresent()) {
			quizService.deletar(id);
			return ResponseEntity.noContent().build();
			
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	
	
	
	
}

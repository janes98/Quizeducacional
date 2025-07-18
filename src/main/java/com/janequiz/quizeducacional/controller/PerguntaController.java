package com.janequiz.quizeducacional.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janequiz.quizeducacional.entities.Pergunta;
import com.janequiz.quizeducacional.services.PerguntaService;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

	private final PerguntaService perguntaService;

	public PerguntaController(PerguntaService perguntaService) {
		this.perguntaService = perguntaService;

	}
	

	@GetMapping
	public ResponseEntity<List<Pergunta>> listarTodas() {
	    try {
	        List<Pergunta> perguntas = perguntaService.listarTodas(); 
	        return ResponseEntity.ok(perguntas);  
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body(null);  // Retorna erro 500 se algo der errado
	    }
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pergunta> buscarPorId(@PathVariable Long id) {
		Optional<Pergunta> pergunta = perguntaService.buscarPorId(id);
		return pergunta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}

	@PostMapping
	public Pergunta criar(@RequestBody Pergunta pergunta) {
		return perguntaService.salvar(pergunta);

	}
     
	@PutMapping("/{id}")
	public ResponseEntity<Pergunta> atualizar(@PathVariable Long id, @RequestBody Pergunta perguntaAtualizada) {

		if (perguntaService.buscarPorId(id).isPresent()) {
			perguntaAtualizada.setId(id);
			return ResponseEntity.ok(perguntaService.salvar(perguntaAtualizada));

		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (perguntaService.buscarPorId(id).isPresent()) {
			perguntaService.deletar(id);
			return ResponseEntity.noContent().build();

		}

		return ResponseEntity.notFound().build();
	}

}

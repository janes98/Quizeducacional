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

import com.janequiz.quizeducacional.entities.Resposta;
import com.janequiz.quizeducacional.services.RespostaService;


@RestController
@RequestMapping("/respostas")
public class RespostaController {

	private final RespostaService respostaService;

	public RespostaController(RespostaService respostaService) {
		this.respostaService = respostaService;
		
	}

	@GetMapping
	public ResponseEntity<List<Resposta>> listarTodos() {
		try {
			List<Resposta> respostas = respostaService.listarTodas();
			return ResponseEntity.ok(respostas);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Resposta> buscarPorId(@PathVariable Long id) {
		Optional<Resposta> resposta = respostaService.buscarPorId(id);
		return resposta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Resposta>criar(@RequestBody Resposta resposta) {
		try {
			Resposta novaResposta = respostaService.salvar(resposta);
			return ResponseEntity.ok(novaResposta);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Resposta> atualizar(@PathVariable Long id, @RequestBody Resposta respostaAtualizada) {

		if (respostaService.buscarPorId(id).isPresent()) {
			respostaAtualizada.setId(id);
			return ResponseEntity.ok(respostaService.salvar(respostaAtualizada));

		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (respostaService.buscarPorId(id).isPresent()) {
			respostaService.deletar(id);
			return ResponseEntity.noContent().build();

		}

		return ResponseEntity.notFound().build();
	}

}

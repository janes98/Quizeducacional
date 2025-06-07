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

import com.janequiz.quizeducacional.entities.Resultado;
import com.janequiz.quizeducacional.services.ResultadoService;


@RestController
@RequestMapping("/resultados")
public class ResultadoController {
	private final ResultadoService resultadoService;

	public ResultadoController(ResultadoService resultadoService) {
		this.resultadoService = resultadoService;
		
	}
	

	@GetMapping
	public ResponseEntity<List<Resultado>> listarTodos() {
		try {
			List<Resultado> resultados = resultadoService.listarTodas();
			return ResponseEntity.ok(resultados);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@GetMapping("/resultados/usuario/{id}")
	public Optional<Resultado> buscarPorId(@PathVariable Long id) {
		 return resultadoService.buscarPorId(id);
	}

	@PostMapping
	public ResponseEntity<Resultado>criar(@RequestBody Resultado resultado) {
		try {
		   Resultado novoResultado = resultadoService.salvar(resultado);
			return ResponseEntity.ok(novoResultado);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Resultado> atualizar(@PathVariable Long id, @RequestBody Resultado resultadoAtualizado) {

		if (resultadoService.buscarPorId(id).isPresent()) {
			resultadoAtualizado.setId(id);
			return ResponseEntity.ok(resultadoService.salvar(resultadoAtualizado));

		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (resultadoService.buscarPorId(id).isPresent()) {
			resultadoService.deletar(id);
			return ResponseEntity.noContent().build();

		}

		return ResponseEntity.notFound().build();
	}


}

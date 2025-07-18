package com.janequiz.quizeducacional.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janequiz.quizeducacional.dto.ProfessorDTO;
import com.janequiz.quizeducacional.entities.Professor;
import com.janequiz.quizeducacional.services.ProfessorService;

@RestController
@RequestMapping("/professores")
@Validated
public class ProfessorController {

	private final ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;

	}

	@GetMapping
	public List<Professor> listarTodas() {
		return professorService.listarTodas();

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProfessorDTO> buscarPorId(@PathVariable Long id) {
		return professorService.buscarPorId(id).map(professor -> ResponseEntity.ok(new ProfessorDTO(professor)))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Professor> criar(@RequestBody @Validated Professor professor) {
		Professor professorSalvo = professorService.salvar(professor);
		return ResponseEntity.status(201).body(professorSalvo); // Retorna com status 201 (Created)

	}

	@PutMapping("/{id}")
	public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
		if (professorService.buscarPorId(id).isPresent()) {
			professorAtualizado.setId(id);
			return ResponseEntity.ok(professorService.salvar(professorAtualizado));

		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (professorService.buscarPorId(id).isPresent()) {
			professorService.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

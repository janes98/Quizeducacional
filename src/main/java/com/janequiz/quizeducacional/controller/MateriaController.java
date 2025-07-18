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

import com.janequiz.quizeducacional.dto.MateriaDTO;
import com.janequiz.quizeducacional.entities.Materia;
import com.janequiz.quizeducacional.services.MateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaController {
	
	private final MateriaService materiaService;
	
	public MateriaController(MateriaService materiaService) {
		this.materiaService = materiaService;
		
		
		
	}
	
	@GetMapping
	public List<Materia> listarTodas(){
	   return materiaService.listarTodas();
	   
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MateriaDTO> buscarPorId(@PathVariable Long id) {
		Optional<Materia> materia = materiaService.buscarPorId(id);
		return materia.map(m -> ResponseEntity.ok(new MateriaDTO(m))).orElseGet(() -> ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public Materia criar(@RequestBody Materia materia) {
		return materiaService.salvar(materia);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Materia> atualizar(@PathVariable Long id, @RequestBody Materia materiaAtualizada) {
		if (materiaService.buscarPorId(id).isPresent()) {
			materiaAtualizada.setId(id);
			return ResponseEntity.ok(materiaService.salvar(materiaAtualizada));
			
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (materiaService.buscarPorId(id).isPresent()) {
			materiaService.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

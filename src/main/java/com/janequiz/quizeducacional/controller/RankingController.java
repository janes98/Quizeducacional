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

import com.janequiz.quizeducacional.entities.Ranking;
import com.janequiz.quizeducacional.services.RankingService;


@RestController
@RequestMapping("/rankings")

public class RankingController {
	
	private final RankingService rankingService;

	public RankingController(RankingService rankingService) {
		this.rankingService = rankingService;
		
	}

	@GetMapping
	public ResponseEntity<List<Ranking>> listarTodos() {
		try {
			List<Ranking> rankings = rankingService.listarTodos();
			return ResponseEntity.ok(rankings);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Ranking> buscarPorId(@PathVariable Long id) {
		Optional<Ranking> ranking = rankingService.buscarPorId(id);
		return ranking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Ranking>criar(@RequestBody Ranking ranking) {
		try {
			Ranking novoRanking= rankingService.salvar(ranking);
			return ResponseEntity.ok(novoRanking);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Ranking> atualizar(@PathVariable Long id, @RequestBody Ranking rankingAtualizado) {

		if (rankingService.buscarPorId(id).isPresent()) {
			rankingAtualizado.setId(id);
			return ResponseEntity.ok(rankingService.salvar(rankingAtualizado));

		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (rankingService.buscarPorId(id).isPresent()) {
			rankingService.deletar(id);
			return ResponseEntity.noContent().build();

		}

		return ResponseEntity.notFound().build();
	}



}

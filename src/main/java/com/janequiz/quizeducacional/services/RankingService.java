package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Ranking;
import com.janequiz.quizeducacional.repositories.RankingRepository;

@Service

public class RankingService {
	
private final RankingRepository rankingRepository;
	
	public RankingService(RankingRepository rankingRepository) {
		
		this.rankingRepository = rankingRepository;
		
	}
	
	public List<Ranking> listarTodos() {
		return rankingRepository.findAll();
		
	}
	
	public Optional<Ranking> buscarPorId(Long id) {
		return rankingRepository.findById(id);
		
	}
	
	public Ranking salvar(Ranking ranking) {
		return rankingRepository.save(ranking);
		
	}
	
	public void deletar(Long id) {
		rankingRepository.deleteById(id);
	}


}

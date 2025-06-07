package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Pergunta;
import com.janequiz.quizeducacional.repositories.PerguntaRepository;

@Service

public class PerguntaService {
	
	private final PerguntaRepository perguntaRepository;
	
	public PerguntaService(PerguntaRepository perguntaRepository) {
		
		this.perguntaRepository = perguntaRepository;
		
	}
	
	public List<Pergunta> listarTodas() {
		return perguntaRepository.findAll();
		
	}
	
	public Optional<Pergunta> buscarPorId(Long id) {
		return perguntaRepository.findById(id);
		
	}
	
	public Pergunta salvar(Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
		
	}
	
	public void deletar(Long id) {
		perguntaRepository.deleteById(id);
	}

}

package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Resposta;
import com.janequiz.quizeducacional.repositories.RespostaRepository;

@Service
public class RespostaService {
private final RespostaRepository respostaRepository;
	
	public RespostaService(RespostaRepository respostaRepository) {
		
		this.respostaRepository = respostaRepository;
		
	}
	
	public List<Resposta> listarTodas() {
		return respostaRepository.findAll();
		
	}
	
	public Optional<Resposta> buscarPorId(Long id) {
		return respostaRepository.findById(id);
		
	}
	
	public Resposta salvar(Resposta resposta) {
		return respostaRepository.save(resposta);
		
	}
	
	public void deletar(Long id) {
		respostaRepository.deleteById(id);
	}


}

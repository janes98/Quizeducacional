package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Resultado;
import com.janequiz.quizeducacional.repositories.ResultadoRepository;

@Service

public class ResultadoService {
	
private final ResultadoRepository resultadoRepository;
	
	public ResultadoService(ResultadoRepository resultadoRepository) {
		
		this.resultadoRepository = resultadoRepository;
		
	}
	
	public List<Resultado> listarTodas() {
		return resultadoRepository.findAll();
		
	}
	
	public Optional<Resultado> buscarPorId(Long id) {
		return resultadoRepository.findById(id);
		
	}
	
	public Resultado salvar(Resultado resultado) {
		return resultadoRepository.save(resultado);
		
	}
	
	public void deletar(Long id) {
		resultadoRepository.deleteById(id);
	}


}

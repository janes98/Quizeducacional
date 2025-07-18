package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Materia;
import com.janequiz.quizeducacional.repositories.MateriaRepository;


@Service
public class MateriaService {
	
	private final MateriaRepository materiaRepository;

	public 	MateriaService(MateriaRepository materiaRepository) {

		this.materiaRepository = materiaRepository;

	}

	public List<Materia> listarTodas() {
		return materiaRepository.findAll();

	}

	public Optional<Materia> buscarPorId(Long id) {
		return materiaRepository.findById(id);

	}

	public Materia salvar(Materia materia) {
		return materiaRepository.save(materia);

	}

	public void deletar(Long id) {
		materiaRepository.deleteById(id);
	}


}

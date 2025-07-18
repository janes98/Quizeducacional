package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Professor;
import com.janequiz.quizeducacional.repositories.ProfessorRepository;
@Service
public class ProfessorService {
	

	private final ProfessorRepository professorRepository;
	
	
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    // Método para salvar professor com validação de email
    public Professor salvar(Professor professor) {
        // Validação para garantir que o email não seja nulo ou vazio
        if (professor.getEmail() == null || professor.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O email é obrigatório!");
        }
        
        // Aqui você pode incluir outras validações, caso necessário
        return professorRepository.save(professor);
    }
	public List<Professor> listarTodas() {
		return professorRepository.findAll();

	}

	public Optional<Professor> buscarPorId(Long id) {
		return professorRepository.findById(id);

	}


	public void deletar(Long id) {
		professorRepository.deleteById(id);
	}
	

}

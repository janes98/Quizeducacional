package com.janequiz.quizeducacional.dto;

import com.janequiz.quizeducacional.entities.Professor;

public class ProfessorDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	public ProfessorDTO(Professor professor) {
		this.id = professor.getId();
		this.nome = professor.getNome();
		this.email = professor.getEmail();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

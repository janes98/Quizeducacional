package com.janequiz.quizeducacional.dto;

import com.janequiz.quizeducacional.entities.Materia;

public class MateriaDTO {
	
	private Long id;
	private String nome;
	
	public MateriaDTO() {
		
		
	}
	
	public MateriaDTO(Materia materia) {
		this.id = materia.getId();
		this.nome = materia.getNome();
		
				
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
	
	

}

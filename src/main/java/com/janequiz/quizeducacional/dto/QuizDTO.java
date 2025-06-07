package com.janequiz.quizeducacional.dto;

import com.janequiz.quizeducacional.entities.Quiz;

public class QuizDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private Long materiaId;
	private String materiaNome;
	
	public QuizDTO() {
		
		
	}
	
	public QuizDTO(Quiz quiz) {
		this.id = quiz.getId();
		this.nome = quiz.getNome();
		this.descricao = quiz.getDescricao();
		if (quiz.getMateria() != null) {
			this.materiaId = quiz.getMateria().getId();
			this.materiaNome = quiz.getMateria().getNome();
			
			
		}
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(Long materiaId) {
		this.materiaId = materiaId;
	}

	public String getMateriaNome() {
		return materiaNome;
	}

	public void setMateriaNome(String materiaNome) {
		this.materiaNome = materiaNome;
	}
	
	
	
	

}

package com.janequiz.quizeducacional.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.janequiz.quizeducacional.entities.Pergunta;

public class PerguntaDTO {
	
	private Long id;
	private String texto;
	private Long quizId;
	private List<RespostaDTO> respostas;
	
	public PerguntaDTO() {
		
	}
	
	public PerguntaDTO(Pergunta pergunta) {
		this.id = pergunta.getId();
		this.texto = pergunta.getTexto();
		if (pergunta.getQuiz() != null) {
			this.quizId = pergunta.getQuiz().getId();
			
		}
		
		if (pergunta.getRespostas() != null) {
			this.respostas = pergunta.getRespostas().stream()
					.map(RespostaDTO::new)
					.collect(Collectors.toList());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public List<RespostaDTO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaDTO> respostas) {
		this.respostas = respostas;
	}
	
	
	

}

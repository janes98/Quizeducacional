package com.janequiz.quizeducacional.dto;

import com.janequiz.quizeducacional.entities.Resultado;

public class ResultadoDTO {
	
	private Long id;
	private Long usuarioId;
	private Long quizId;
	private Integer pontuacao;
	
	public ResultadoDTO() {
		
	}
	
	public ResultadoDTO(Resultado resultado) {
		this.id = resultado.getId();
		if (resultado.getUsuario() != null) {
			this.usuarioId = resultado.getUsuario().getId();
			
		}
		if (resultado.getQuiz() != null) {
			this.quizId = resultado.getQuiz().getId();		
			
		}
		this.pontuacao = resultado.getPontuacao();
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	

}

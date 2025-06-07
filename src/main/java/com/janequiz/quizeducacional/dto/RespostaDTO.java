package com.janequiz.quizeducacional.dto;

import com.janequiz.quizeducacional.entities.Resposta;

public class RespostaDTO {
	
	private Long id;
	private String texto;
	private boolean correta;
	
	public RespostaDTO() {
		
		
	}
	
	public RespostaDTO(Resposta resposta) {
		this.id = resposta.getId();
		this.texto = resposta.getTexto();
		this.correta = resposta.isCorreta();
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

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}

	
	

}

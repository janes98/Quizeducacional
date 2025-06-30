package com.janequiz.quizeducacional.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private Integer pontuacao;

	private LocalDateTime dataResultado;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "quiz_id", referencedColumnName = "id")
	private Quiz quiz;

	public Resultado() {

	}

	public Resultado(Integer pontuacao, Usuario usuario, Quiz quiz) {
		
		this.pontuacao = pontuacao;
		this.usuario = usuario;
		this.quiz = quiz;
		this.dataResultado = LocalDateTime.now();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public LocalDateTime getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(LocalDateTime dataResultado) {
		this.dataResultado = dataResultado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	

}

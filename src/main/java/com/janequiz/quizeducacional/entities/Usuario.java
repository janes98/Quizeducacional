package com.janequiz.quizeducacional.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.janequiz.quizeducacional.model.Formacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private String senha;

	@Enumerated(EnumType.STRING)

	private Formacao formacao;

	private String escolaUniversidade;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;


	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	
	private List<Ranking> rankings;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Resultado> resultados;

	public Usuario() {

	}

	public Usuario(String nome, String email, String senha, Formacao formacao, String escolaUniversidade,
			LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.formacao = formacao;
		this.escolaUniversidade = escolaUniversidade;
		this.dataNascimento = dataNascimento;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public String getEscolaUniversidade() {
		return escolaUniversidade;
	}

	public void setEscolaUniversidade(String escolaUniversidade) {
		this.escolaUniversidade = escolaUniversidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Ranking> getRankings() {
		return rankings;
	}

	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
	
	

	
}

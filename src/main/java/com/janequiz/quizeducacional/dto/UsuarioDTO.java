package com.janequiz.quizeducacional.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.janequiz.quizeducacional.entities.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
	private List<ResultadoDTO> resultados;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario usuario) {
		
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		
		if (usuario.getResultados() != null) {
			
			this.resultados = usuario.getResultados().stream()
					.map(ResultadoDTO::new)
					.collect(Collectors.toList());
			
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ResultadoDTO> getResultados() {
		return resultados;
	}

	public void setResultados(List<ResultadoDTO> resultados) {
		this.resultados = resultados;
	}
	
	

}

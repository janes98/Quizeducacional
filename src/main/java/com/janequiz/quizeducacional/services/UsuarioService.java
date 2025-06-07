package com.janequiz.quizeducacional.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.janequiz.quizeducacional.entities.Usuario;
import com.janequiz.quizeducacional.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		
		this.usuarioRepository = usuarioRepository;
		
	}
	
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
		
	}
	
	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
		
	}
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}


}

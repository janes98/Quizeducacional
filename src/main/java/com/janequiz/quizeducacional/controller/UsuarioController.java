package com.janequiz.quizeducacional.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janequiz.quizeducacional.entities.Usuario;
import com.janequiz.quizeducacional.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos() {
		try {
			List<Usuario> usuarios = usuarioService.listarTodos();
			return ResponseEntity.ok(usuarios);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Usuario>criar(@RequestBody Usuario usuario) {
		try {
			Usuario novoUsuario= usuarioService.salvar(usuario);
			return ResponseEntity.ok(novoUsuario);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

		if (usuarioService.buscarPorId(id).isPresent()) {
			usuarioAtualizado.setId(id);
			return ResponseEntity.ok(usuarioService.salvar(usuarioAtualizado));

		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		if (usuarioService.buscarPorId(id).isPresent()) {
			usuarioService.deletar(id);
			return ResponseEntity.noContent().build();

		}

		return ResponseEntity.notFound().build();
	}


}

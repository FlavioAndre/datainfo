package br.com.datainfo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.datainfo.domain.Usuario;
import br.com.datainfo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario save(Usuario usuario) {
		return this.repository.save(usuario);
	}

	public Collection<Usuario> findAll() {
		return this.repository.findAll();
	}

	public void delete(Usuario usuario) {
		this.delete(usuario);
	}

	public Usuario findById(Long id) {
		return this.repository.findById(id).get();
	}

	public Usuario filter(String nome, Integer perfil, String situacao) {
		return this.repository.findByNoUsuarioAndIcPerfilAcessoAndIcSituacao(nome, perfil, situacao);

	}

	public void deleteById(String id) {
		this.repository.deleteById(Long.valueOf(id));
	}
}

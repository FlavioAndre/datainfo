package br.com.datainfo.web.rest;

import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.domain.Usuario;
import br.com.datainfo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
	private final Logger log = LoggerFactory.getLogger(UsuarioResource.class);
	@Autowired
	private final UsuarioService usuarioService;

	public UsuarioResource(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public Usuario save(@Valid @RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}

	@PutMapping("/{id}")
	public Usuario update(@Valid @RequestBody Usuario usuario, @PathVariable("id") String id) {
		Usuario temp = this.usuarioService.findById(Long.valueOf(id));
		temp.setCoFuncao(usuario.getCoFuncao());
		temp.setDeEmail(usuario.getDeEmail());
		temp.setIcPerfilAcesso(usuario.getIcPerfilAcesso());
		temp.setIcSituacao(usuario.getIcSituacao());
		temp.setNoUsuario(usuario.getNoUsuario());
		temp.setNuCpf(usuario.getNuCpf());
		temp.setNuTelefone(usuario.getNuTelefone());
		return this.usuarioService.save(usuario);
	}

	@GetMapping
	public Collection<Usuario> findAll() {
		return this.usuarioService.findAll();
	}

	@GetMapping("/filter")
	public Usuario filter(@RequestParam("nome") String nome, @RequestParam("perfil") String perfil,
			@RequestParam("situacao") String situacao) {
		return this.usuarioService.filter(nome, Integer.parseInt(perfil), situacao);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.usuarioService.deleteById(id);
	}
}

package br.com.datainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.datainfo.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByNoUsuarioAndIcPerfilAcessoAndIcSituacao(String noUsuario, Integer icPerfilAcesso, String icSituacao);
}

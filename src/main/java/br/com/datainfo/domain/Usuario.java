
package br.com.datainfo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nu_cpf", "no_usuario", "de_email", "ic_situacao", "ic_perfil_acesso", "co_funcao",
		"nu_telefone" })
@Entity
@Table(name = "usuario_externo")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 109384239793748L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	@JsonProperty("id")
	private Long id;
	@JsonProperty("nu_cpf")
	private String nuCpf;
	@JsonProperty("no_usuario")
	private String noUsuario;
	@JsonProperty("de_email")
	private String deEmail;
	@JsonProperty("ic_situacao")
	private String icSituacao;
	@JsonProperty("ic_perfil_acesso")
	private Integer icPerfilAcesso;
	@JsonProperty("co_funcao")
	@OneToOne
	@JoinColumn(name = "co_funcao")
	private FuncaoUsuario coFuncao;
	@JsonProperty("nu_telefone")
	private String nuTelefone;

}

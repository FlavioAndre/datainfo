package br.com.datainfo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "co_funcao", "no_funcao" })
@Entity
@Table(name = "funcao_usuario_externo")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class FuncaoUsuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 908230402384028341L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fueSequenceGenerator")
	@SequenceGenerator(name = "fueSequenceGenerator", sequenceName = "fue_hibernate_sequence")
	@JsonProperty("co_funcao")
	private Long coFuncao;
	@JsonProperty("no_funcao")
	private String noFuncao;
}

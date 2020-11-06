package br.edu.cesmac.jobsapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity

public class Habilidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "habilidade_id" )
	private Long habilidade_id;
	@NotEmpty(message = "O nome é obrigatório")
	private String nome;
	@NotEmpty(message = "A descrição é obrigatória")
	private String descricao;
	
	
	public Long getHabilidade_id() {
		return habilidade_id;
	}
	public void setHabilidade_id(Long habilidade_id) {
		this.habilidade_id = habilidade_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Habilidade(Long habilidade_id, String nome, String descricao) {
		super();
		this.habilidade_id = habilidade_id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
	
}

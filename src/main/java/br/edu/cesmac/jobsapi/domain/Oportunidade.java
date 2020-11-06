package br.edu.cesmac.jobsapi.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Oportunidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oportunidade_id" )
	private Long oportunidade_id;
	@NotEmpty(message = "O título é obrigatório")
	private String titulo;
	@NotEmpty(message = "A descrição é obrigatória")
	private String descricao;
	@NotEmpty(message = "A data de início é obrigatória")
	private Date dataInicio;
	@NotEmpty(message = "A data de término é obrigatória")
	private Date dataTermino;
	@NotEmpty
	private Long empresa_id;
	@OneToMany(mappedBy = "oportunidade")
    List<Habilidade> habilidades;
	
	
	public Long getOportunidade_id() {
		return oportunidade_id;
	}
	public void setOportunidade_id(Long oportunidade_id) {
		this.oportunidade_id = oportunidade_id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Long getEmpresa_id() {
		return empresa_id;
	}
	public void setEmpresa_id(Long empresa_id) {
		this.empresa_id = empresa_id;
	}
	public Oportunidade(Long oportunidade_id, String titulo, String descricao, Date dataInicio, Date dataTermino, Long empresa_id) {
		super();
		this.oportunidade_id = oportunidade_id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.empresa_id = empresa_id;
	}
	
	
}

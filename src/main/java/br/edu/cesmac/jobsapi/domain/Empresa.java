package br.edu.cesmac.jobsapi.domain;



import java.util.List;

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
@Table(
        name="Pessoa",
        uniqueConstraints=
            @UniqueConstraint(columnNames={"email"})
    )
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empresa_id" )
	private Long empresa_id;
	@NotEmpty(message = "O nome é obrigatório")
	private String nome;
	@NotEmpty(message = "O email é obrigatória")
	@Column(unique=true)
	private String email;
	@NotEmpty(message = "O site é obrigatório")
	private String site;
	@OneToMany(mappedBy = "empresa")
    List<Oportunidade> oportunidades;
	
	
	
	public Long getEmpresa_id() {
		return empresa_id;
	}
	public void setEmpresa_id(Long empresa_id) {
		this.empresa_id = empresa_id;
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Empresa(Long empresa_id, String nome, String email, String site) {
		super();
		this.empresa_id = empresa_id;
		this.nome = nome;
		this.email = email;
		this.site = site;
	}
	
	
}

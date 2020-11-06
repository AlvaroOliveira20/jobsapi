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
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pessoa_id" )
	private Long pessoa_id;
	@NotEmpty(message = "O nome é obrigatório")
	private String nome;
	@NotEmpty(message = "A data de nascimento é obrigatória")
	private String dataNascimento;
	@NotEmpty(message = "Informar o sexo é obrigatório")
	private String sexo;
	@NotEmpty(message = "Email é obrigatório")
	@Column(unique=true)
	private String email;
	@OneToMany(mappedBy = "pessoa")
    List<Habilidade> habilidades;
	
	
	public Long getPessoa_id() {
		return pessoa_id;
	}
	public void setPessoa_id(Long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Pessoa(Long pessoa_id, String nome, String dataNascimento, String sexo, String email) {
		super();
		this.pessoa_id = pessoa_id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
	}
	
	
	
	
	
}
package br.edu.ifrs.provapratica.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nome;
	private String email;
	
	@ManyToOne
	private Curso curso;

	public Aluno() {}

	public Aluno(String nome, String email, Curso curso) {
		this.nome = nome;
		this.email = email;
		curso.adicionarAluno(this);
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}
	
	
	
}

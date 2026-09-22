package br.edu.ifrs.provapratica.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nome;
	private int cargaHoraria;
	@Enumerated(EnumType.STRING)
	private StatusCurso status;
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos;
	
	public Curso() {
		this.alunos = new ArrayList<Aluno>();
		}

	public Curso(String nome, int cargaHoraria, StatusCurso status, List<Aluno> alunos) {
		this();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public StatusCurso getStatus() {
		return status;
	}

	public void setStatus(StatusCurso status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
		aluno.setCurso(this);
	}
	
	
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	
	
}

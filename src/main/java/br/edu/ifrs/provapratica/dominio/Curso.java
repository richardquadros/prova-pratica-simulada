package br.edu.ifrs.provapratica.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Curso {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nome;
	private int cargaHoraria;
	
	private StatusCurso status;
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Curso() {}

	public Curso(String nome, int cargaHoraria, StatusCurso status, List<Aluno> alunos) {
		super();
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
	
	public List<Aluno> listarAlunos() {
		List<Aluno> listaAlunos = this.alunos;
		for(Aluno aluno: listaAlunos) {
			listaAlunos.add(aluno);
		}
		
		return alunos;
	}
	
}

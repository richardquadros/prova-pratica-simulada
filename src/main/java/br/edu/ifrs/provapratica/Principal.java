package br.edu.ifrs.provapratica;

import java.util.List;

import br.edu.ifrs.provapratica.dao.CursoDAO;
import br.edu.ifrs.provapratica.dao.CursoDAOJPA;
import br.edu.ifrs.provapratica.dominio.Aluno;
import br.edu.ifrs.provapratica.dominio.Curso;
import br.edu.ifrs.provapratica.dominio.StatusCurso;


public class Principal {

	public static void main(String[] args) {

		/*
		  2. Classe Executável de Teste Crie uma classe de execução (ex: Principal)
		  contendo o método main. 
		  No fluxo de execução: Instancie os objetos de domínio
		 e 
		 persista 1 Curso e pelo menos 2 Alunos associados a ele. 
		 Execute a atualização dos dados do curso no banco. 
		 Execute a remoção de um dos alunos cadastrados. 
		 Invoque a consulta personalizada em JPQL para listar e exibir no
		  console apenas os cursos filtrados pelo status ATIVO.
		 */
		
		CursoDAO gerenciadorCurso = new CursoDAOJPA();
		
		// 1. Instanciar Curso e Alunos
		Curso curso1 = new Curso("SI", 2218, StatusCurso.ATIVO);
		Aluno aluno1 = new Aluno("Arthur Verocai", "MPB@gmail.com", curso1);
		Aluno aluno2 = new Aluno("Milton Nascimento", "MPB2@gmail.com", curso1);
		
		// Persistir Cursos
		gerenciadorCurso.salvar(curso1);
		gerenciadorCurso.salvar(new Curso("Redes de computadores", 4030, StatusCurso.INATIVO));
		
		// 2. Atualizar dados do curso
		curso1.setCargaHoraria(3000);  //atualizacao dos dados
		gerenciadorCurso.atualizar(curso1);
		
		// 3. Remover curso pelo ID (exemplo ID 2)
		gerenciadorCurso.remover(2L);
		
		// 4. Buscar e Imprimir resultados JPQL no Console
		List<Curso> cursoFiltrado = gerenciadorCurso.buscarPorStatus(StatusCurso.ATIVO);
		
		for(Curso curso : cursoFiltrado) {
			System.out.println("Nome do curso: "+curso.getNome());
		}
	}

}

package br.edu.ifrs.provapratica.dao;
import java.util.List;

import br.edu.ifrs.provapratica.dominio.Curso;
import br.edu.ifrs.provapratica.dominio.StatusCurso;

public interface CursoDAO {

	public void salvar(Curso curso);
	public void atualizar(Curso curso);
	public void remover(Long id);
	Curso buscarPorId(Long id);
	List<Curso> listarTodos();
	List<Curso> buscarPorStatus(StatusCurso status);
}

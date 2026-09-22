package br.edu.ifrs.provapratica.dao;

import java.util.List;

import br.edu.ifrs.provapratica.dominio.Curso;
import br.edu.ifrs.provapratica.dominio.StatusCurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoDAOJPA implements CursoDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("prova-pratica-simulada-pu");
	
	@Override
	public void salvar(Curso curso) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
		em.close();
		System.out.println("Curso "+curso.getNome()+" salvo com sucesso!");
	}

	@Override
	public void atualizar(Curso curso) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();
		em.close();
		System.out.println("Curso "+curso.getNome()+" atualizado com sucesso!");
	}

	@Override
	public void remover(Long id) {
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    Curso curso = em.find(Curso.class, id);
	    em.remove(curso);
	    em.getTransaction().commit();
	    em.close();
	    System.out.println("Curso "+curso.getNome()+" removido com sucesso!");
	}

	@Override
	public Curso buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Curso cursoObtido = em.find(Curso.class, id);
		em.close();
		return cursoObtido;
	}

	@Override
	public List<Curso> listarTodos() {
		EntityManager em = emf.createEntityManager();
		List<Curso> listaCursos = em.
				createQuery("SELECT c FROM Curso c", Curso.class)
				.getResultList();
		em.close();
		return listaCursos;
	}

	@Override
	public List<Curso> buscarPorStatus(StatusCurso status) {
		EntityManager em = emf.createEntityManager();
				
		List<Curso> cursoFiltrado = em
				.createQuery("SELECT c FROM Curso c where c.status = :status", Curso.class)
				.setParameter("status", status)
				.getResultList();
		em.close();
		return cursoFiltrado;
	}
	
}

package sample.music.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class AbstractRepository<E> {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<E> clazz;

	public AbstractRepository() {
		//empty
	}
	
	AbstractRepository(Class<E> clazz) {
		this.clazz = clazz;
	}

	public List<E> findAll() {
		return em.createQuery("select a from Artist a order by a.name", clazz).getResultList();
	}

	public E findById(Integer id) {
		return em.find(clazz, id);
	}

}
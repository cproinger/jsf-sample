package sample.music.repo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.annotations.QueryHints;

import sample.common.MonitoredCDIBean;

@MonitoredCDIBean
abstract class AbstractRepository<E> implements SimpleRepository<E> {

//	@PersistenceContext
	@Inject
//	@RequestScoped
	protected EntityManager em;
	
	private Class<E> clazz;

	public AbstractRepository() {
		//empty
	}
	
	AbstractRepository(Class<E> clazz) {
		this.clazz = clazz;
	}

	@Override
	@MonitoredCDIBean
	public List<E> findAll(String loadgraph) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<E> cqry = cb.createQuery(clazz);
		Root<E> root = cqry.from(clazz);
		cqry.orderBy(cb.asc(root.get(getDefaultSortProperty())));
//		cqry.orderBy(cb.or);
//		cqry = em.createquery
		TypedQuery<E> q = em.createQuery(cqry);
		if(loadgraph != null) {
			q.setHint(QueryHints.LOADGRAPH, em.createEntityGraph(loadgraph));
		}
		return q.getResultList();
	}
	@Override
	@MonitoredCDIBean
	public List<E> findAll() {
		return findAll(null);
	}

	protected abstract String getDefaultSortProperty();
	@Override
	public E findById(Integer id) {
		return findById(id, null);
	}
	@Override
	public E findById(Integer id, String loadgraph) {
		//ignore for now, use enableFetchProfile, that seems to work better (honor max fetch depth). 
		Map<String, Object> ps = loadgraph == null
				? Collections.emptyMap()
				: Collections.singletonMap(QueryHints.FETCHGRAPH, em.createEntityGraph(loadgraph));
		
//		if(loadgraph != null)
//			em.unwrap(Session.class).enableFetchProfile(loadgraph);
		return em.find(clazz, id, ps);
	}

	@Override
	public E save(E e) {
		E merged = em.merge(e);
		em.flush();
		return merged;
	}
}
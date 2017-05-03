package sample.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@ApplicationScoped
public class AppUserRepository {

	@PersistenceContext
	private EntityManager em;
	
	public AppUser findOne(Long id) {
		return em.find(AppUser.class, id);
	}
	
	public AppUser save(AppUser u) {
		em.persist(u);
		em.flush();
		return u;
	}
}

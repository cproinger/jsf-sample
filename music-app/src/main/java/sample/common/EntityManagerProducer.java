package sample.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * open entity manager in view pattern
 * 
 * https://jaxenter.de/java-ee-architekturen-und-jpa-verwendung-des-entitymanager-im-java-ee-stack-2339
 * 
 * @author cproinger
 *
 */
@ApplicationScoped
public class EntityManagerProducer {

	@javax.persistence.PersistenceUnit
	private EntityManagerFactory emf;
	
	@Produces
	@RequestScoped
	public EntityManager crateEntityManager() {
		return emf.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
}

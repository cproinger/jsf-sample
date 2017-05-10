package sample.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.picketlink.annotations.PicketLink;

/**
 * open entity manager in view pattern
 * 
 * https://jaxenter.de/java-ee-architekturen-und-jpa-verwendung-des-entitymanager-im-java-ee-stack-2339
 * 
 * @author cproinger
 *
 */
@ApplicationScoped
//@Log
public class EntityManagerProducer {
	
	@javax.persistence.PersistenceUnit
	private EntityManagerFactory emf;

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * hm this entityManager is not closed until shutdown. seems leaky. 
	 * @return
	 */
	@Produces
	@PicketLink
	public EntityManager createPicketLinkEntityManager() {
		return emf.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
	
	public void closePicketLinkEntityManager(@Disposes @PicketLink EntityManager em) {
		em.close();
	}
}

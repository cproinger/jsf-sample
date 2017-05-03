package sample.user;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AppUserService {

	private final static Logger log = LoggerFactory.getLogger(AppUserService.class);
	
	@Inject
	private AppUserRepository userRepository;
	
	public AppUser create(AppUser u) throws UsernameAlreadyInUseException {
		try {
			AppUser result = userRepository.save(u);
			log.info("creating user " + u);
			return result;
		} catch(PersistenceException e) {
			if(e.getCause() instanceof ConstraintViolationException)
				throw new UsernameAlreadyInUseException();
			throw e;
		}
	}
	
	public AppUser findOne(Long id) {
		return userRepository.findOne(id);
	}
}

package sample.music.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import sample.music.domain.Artist;

@Named
@ApplicationScoped
public class ArtistRepository extends AbstractRepository<Artist> {

	public ArtistRepository() {
		super(Artist.class);
	}

	@Override
	protected String getDefaultSortProperty() {
		return "name";
	}

	public List<Artist> findByNameLike(String nameStart) {
		return em.createQuery("select a from Artist a where a.name LIKE :nameStart order by a.name", Artist.class)
				.setParameter("nameStart", nameStart + "%")
				.getResultList();
	}
}

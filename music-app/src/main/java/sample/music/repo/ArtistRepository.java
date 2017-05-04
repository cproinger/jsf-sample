package sample.music.repo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import sample.music.domain.Artist;

@Named
@ApplicationScoped
public class ArtistRepository extends AbstractRepository<Artist> {

	public ArtistRepository() {
		super(Artist.class);
	}
}

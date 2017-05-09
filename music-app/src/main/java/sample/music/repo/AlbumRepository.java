package sample.music.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import sample.music.domain.Album;

@Named
@ApplicationScoped
public class AlbumRepository extends AbstractRepository<Album> {

	public AlbumRepository() {
		super(Album.class);
	}

	public List<Album> findByArtistId(Integer artistId) {
		return em.createQuery("select a from Album a where a.artist.id = :artistId", Album.class)
				.setParameter("artistId", artistId)
				.getResultList();
	}

	@Override
	protected String getDefaultSortProperty() {
		return "title";
	}
}

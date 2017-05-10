package sample.music.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import sample.music.domain.Album;

@Named
@ApplicationScoped
class AlbumRepositoryImpl extends AbstractRepository<Album> implements AlbumRepository {

	public AlbumRepositoryImpl() {
		super(Album.class);
	}

	/* (non-Javadoc)
	 * @see sample.music.repo.AlbumRepository#findByArtistId(java.lang.Integer)
	 */
	@Override
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

package sample.music.repo;

import java.util.List;

import sample.music.domain.Album;

public interface AlbumRepository extends SimpleRepository<Album> {

	List<Album> findByArtistId(Integer artistId);

}
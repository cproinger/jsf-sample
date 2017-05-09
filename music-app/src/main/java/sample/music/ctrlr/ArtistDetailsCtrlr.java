package sample.music.ctrlr;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sample.common.MonitoredCDIBean;
import sample.music.domain.Album;
import sample.music.domain.Artist;
import sample.music.repo.AlbumRepository;
import sample.music.repo.ArtistRepository;

@Named
@RequestScoped
public class ArtistDetailsCtrlr {

	@Inject
	private AlbumRepository albumRepo;
	private List<Album> albums;
	
	private Artist artist;
	private Integer artistId;
	
	@Inject
	private ArtistRepository artistRepo;
	
//	@Inject
//	public ArtistDetailsCtrlr(ArtistRepository artistRepo, AlbumRepository albumRepo) {
//		this.artistRepo = artistRepo;
//		this.albumRepo = albumRepo;
//	}
	
	public List<Album> getAlbums() {
		return albums;
	}
	public Artist getArtist() {
		return artist;
	}
	
	public Integer getArtistId() {
		return artistId;
	}
	
	@MonitoredCDIBean
	public void onLoad() {
		if(artistId == null)
			return;
		artist = artistRepo.findById(artistId);
		albums = albumRepo.findByArtistId(artistId);
	}
	
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
}

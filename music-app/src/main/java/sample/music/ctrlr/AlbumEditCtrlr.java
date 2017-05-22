package sample.music.ctrlr;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import sample.common.Log;
import sample.music.domain.Album;
import sample.music.domain.Artist;
import sample.music.repo.AlbumRepository;
import sample.music.repo.ArtistRepository;

@ViewScoped
@Named
public class AlbumEditCtrlr implements Serializable {

	private static final long serialVersionUID = 1L;

	private Album album;
	
	private Integer albumId;

	@Inject
	private AlbumRepository albumRepo;
	
	@Inject
	private ArtistRepository artistRepo;
	
	public Album getAlbum() {
		return album;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	
	public void onLoad() {
		album = albumRepo.findById(albumId);
	}
	
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	
	public List<Artist> completeArtist(String nameStart) {
		return artistRepo.findByNameLike(nameStart);
	}
	
	@Transactional
	@Log
	public String save() {
		album = albumRepo.save(album);
		return "/albumDetails?faces-redirect=true&includeViewParams=true";
	}
}

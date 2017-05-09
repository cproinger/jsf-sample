package sample.music.ctrlr;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sample.common.MonitoredCDIBean;
import sample.music.domain.Album;
import sample.music.repo.AlbumRepository;

@RequestScoped
@Named
public class AlbumDetailsCtrlr {

	@Inject
	private AlbumRepository albumRepo;
	private Album album;
	
	private Integer albumId;
	
	@MonitoredCDIBean
	public void onLoad() {
		if(albumId == null)
			return;
		album = albumRepo.findById(albumId);//, Album.GRAPH_ALBUM_DETAILS);
	}
	
	public Integer getAlbumId() {
		return albumId;
	}
	
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	
	public Album getAlbum() {
		return album;
	}
}

package sample.music.ctrlr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sample.common.MonitoredCDIBean;
import sample.music.domain.Album;
import sample.music.repo.AlbumRepository;

@Named
//??? loadAlbums Called twice? @RequestScoped //replaced @ViewScoped, to albumTracks-lazy loading works.
@ViewScoped
public class AlbumListCtrlr implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Album> albums = new ArrayList<Album>();
	private List<Album> filteredAlbums;
	
	public List<Album> getAlbums() {
		return albums;
	}
	
	public List<Album> getFilteredAlbums() {
		return filteredAlbums;
	}
	public void setFilteredAlbums(List<Album> filteredAlbums) {
		this.filteredAlbums = filteredAlbums;
	}
	
	@Inject
	private AlbumRepository albumRepo;
	
	@PostConstruct
	@MonitoredCDIBean
	void loadAlbums() {
		albums = albumRepo.findAll(Album.GRAPH_ALBUM_TRACK_COUNT);
	}
}

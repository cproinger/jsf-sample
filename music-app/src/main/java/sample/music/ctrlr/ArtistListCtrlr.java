package sample.music.ctrlr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sample.common.MonitoredCDIBean;
import sample.music.domain.Artist;
import sample.music.repo.ArtistRepository;
import sample.music.service.ArtistService;

@Named
@ViewScoped
public class ArtistListCtrlr implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Artist> artists = new ArrayList<Artist>();
	private List<Artist> filteredArtists;
	
	public List<Artist> getArtists() {
		return artists;
	}
	
	public List<Artist> getFilteredArtists() {
		return filteredArtists;
	}
	public void setFilteredArtists(List<Artist> filteredArtists) {
		this.filteredArtists = filteredArtists;
	}
	
	@Inject
	private ArtistRepository artistRepo;
	
	@Inject
	private ArtistService artistService;
	
	@PostConstruct
	@MonitoredCDIBean
	void loadArtists() {
		artists = artistService.findAll();
	}
}

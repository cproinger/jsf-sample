package sample.music.ctrlr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sample.music.domain.Artist;
import sample.music.repo.ArtistRepository;

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
	
	@PostConstruct
	void loadArtists() {
		artists = artistRepo.findAll();
	}
}

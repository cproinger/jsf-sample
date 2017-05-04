package sample.music.ctrlr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sample.music.domain.Artist;
import sample.music.repo.ArtistRepository;

@Named
@RequestScoped
public class ArtistListCtrlr {

	private List<Artist> artists = new ArrayList<Artist>();
	
	public List<Artist> getArtists() {
		return artists;
	}
	
	@Inject
	private ArtistRepository artistRepo;
	
	@PostConstruct
	void loadArtists() {
		artists = artistRepo.findAll();
	}
}

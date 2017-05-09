package sample.music.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import sample.music.domain.Artist;
import sample.music.repo.ArtistRepository;

@Stateless
public class ArtistService {

	@Inject
	private ArtistRepository artistRepo;
	
	public List<Artist> findAll() {
		return artistRepo.findAll();
	}
}

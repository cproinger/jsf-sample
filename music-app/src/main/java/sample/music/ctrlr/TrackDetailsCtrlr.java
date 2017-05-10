package sample.music.ctrlr;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import sample.music.domain.Track;

@RequestScoped
@Named
public class TrackDetailsCtrlr {

	private Track track;
	
	@PostConstruct
	public void dummy() {
		track = new Track();
		track.setComposer("composer XXX");
		track.setBytes(3444);
		track.setMilliseconds(90542);
		track.setName("dummy track");
		track.setUnitprice(new BigDecimal(3.99));
	}
	
	public Track getTrack() {
		return track;
	}
}

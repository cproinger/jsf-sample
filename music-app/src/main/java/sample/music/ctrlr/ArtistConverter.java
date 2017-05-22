package sample.music.ctrlr;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import sample.music.domain.Artist;
import sample.music.repo.ArtistRepository;

@Named
@ApplicationScoped
public class ArtistConverter implements Converter {

	@Inject
	private ArtistRepository artistRepo;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.trim().length() <= 0)
			return null;
		
		int artistId = Integer.parseInt(value);
		return artistRepo.findById(artistId);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) return null;

		return ((Artist) value).getId().toString() ;
	}

}

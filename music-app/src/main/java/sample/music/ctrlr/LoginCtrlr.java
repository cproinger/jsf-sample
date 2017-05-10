package sample.music.ctrlr;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "login")
@RequestScoped
public class LoginCtrlr {

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login";
	}
}

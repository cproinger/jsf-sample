package sample.user;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named
@RequestScoped
public class RegistrationCtrlr {

	@NotNull
	private String username;

	@EJB
	private AppUserService userService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String register() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			userService.create(new AppUser(username));
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Registered '" + username + "'",
					"Registered '" + username + "'");
			fc.addMessage(null, message);
			//http://stackoverflow.com/questions/32843135/redirect-login-page-to-another-page-in-jsf
			return "userDetails.xhtml?faces-redirect=true";
		} catch (UsernameAlreadyInUseException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Username " + username + " is already in use",
					"Username " + username + " is already in use");
			fc.addMessage(null, message);
		}
		return null;
		
	}
}

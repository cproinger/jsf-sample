package sample.user;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class SessionCtrlr implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;

	private String username;
	
	public String getUsername() {
		return username;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public String login() {
		loggedIn = true;
		username = "user1";
		return redirectToCurrentPage();
	}

	private String redirectToCurrentPage() {
		return FacesContext.getCurrentInstance().getViewRoot().getViewId()+"?faces-redirect=true&includeViewParams=true";
	}
	public String logout() {
		loggedIn = false;
		username = null;
		return redirectToCurrentPage();
	}
}

package sample.user;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;

@Named
@RequestScoped
public class LoginCtrlr {

	@Inject
	private Identity identity;
	
	@Inject
	private SessionCtrlr sessionCtrlr;
	
	public void login() {
		AuthenticationResult result = identity.login();
		if(AuthenticationResult.FAILED == result) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    "Authentication was unsuccessful.  Please check your username and password " + "before trying again."));
		}
	}
}

package sample.common;

import javax.enterprise.event.Observes;

import org.picketlink.event.SecurityConfigurationEvent;
import org.picketlink.http.HttpMethod;

public class HttpSecurityConfiguration {

	public void onInit(@Observes SecurityConfigurationEvent event) {
		event.getBuilder().http()
			.forPath("/javax.faces.resource/*")
				.withMethod(HttpMethod.GET)
				.unprotected()
			.forPath("/index.xhtml")
				.unprotected()
			.forPath("/registration.xhtml")
				.unprotected()				
			.forPath("/logout")
				.logout()
				.redirectTo("/index.xhtml")
			.forPath("/*")
				.authenticateWith()
					.form()
						.authenticationUri("/login.xhtml")
						.loginPage("/login.xhtml")
						.errorPage("/fail_login.xhtml")
						.restoreOriginalRequest()

						
				;
	}
}

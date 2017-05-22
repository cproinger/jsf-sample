package sample.common;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ThemeCtrlr implements Serializable {

	private static final long serialVersionUID = 1L;

	private String theme = "afterwork";
	
	public String getTheme() {
		return theme;
	}
}

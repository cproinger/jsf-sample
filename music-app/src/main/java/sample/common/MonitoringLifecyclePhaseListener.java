package sample.common;

import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.component.lifecycle.LifecyclePhaseListener;
import org.primefaces.component.lifecycle.PhaseInfo;

import io.prometheus.client.Summary;

public class MonitoringLifecyclePhaseListener extends LifecyclePhaseListener {
	private static final long serialVersionUID = 1L;
	
	private final static Summary sum = Summary.build("jsf_lifecycle", "duration of lifecycle phases")
			.labelNames("path", "phase", "ajax")
			.quantile(0.25, 0.1)
			.quantile(0.5, 0.1)
			.quantile(0.75, 0.1)
			.quantile(0.95, 0.1)
			.register();
	
	@Override
	public void afterPhase(PhaseEvent event) {
		super.afterPhase(event);
		
		if (isGetLifecycleInfoRequest(event.getFacesContext())) {
            return;
        }
        PhaseInfo phaseInfo = getPhaseInfo(event.getPhaseId(), event.getFacesContext());
        
        HttpServletRequest r = (HttpServletRequest) event.getFacesContext().getExternalContext().getRequest();
		String requestURI = r.getRequestURI();
		String applicationContextPath = event.getFacesContext().getExternalContext().getApplicationContextPath();
		String monPath = requestURI.substring(applicationContextPath.length());
		String isAjax = event.getFacesContext().getPartialViewContext().isAjaxRequest()+"";
		sum.labels(monPath, event.getPhaseId().getName(), isAjax).observe(phaseInfo.getDuration());
//        if(PhaseId.RENDER_RESPONSE.equals(event.getPhaseId())) {
//        	sum.labels("all").observe(phaseInfo.getDuration());
//        }
	}
}

package sample.common;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;

import io.prometheus.client.hotspot.DefaultExports;

@Startup
public class PrometheusInitializer {

	@PostConstruct
	public void init() {
		DefaultExports.initialize();
	}
}

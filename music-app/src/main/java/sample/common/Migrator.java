package sample.common;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class Migrator {

	private final Logger log = LoggerFactory.getLogger(Migrator.class);
	 
	@Resource(lookup = "java:jboss/datasources/MusicDS")
	private DataSource dataSource;
 
	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private void onStartup() {
		if (dataSource == null) {
			log.error("no datasource found to execute the db migrations!");
			throw new EJBException(
					"no datasource found to execute the db migrations!");
		}
 
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource);
//		for (MigrationInfo i : flyway.info().all()) {
//			log.info("migrate task: " + i.getVersion() + " : "
//					+ i.getDescription() + " from file: " + i.getScript());
//		}
		flyway.migrate();
	}
}

package sample.music.ctrlr;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import sample.TestUtils;

@RunWith(Arquillian.class)
public class TrackDetailsCtrlrTest {

	@Deployment
	public static WebArchive deployment() {
		return TestUtils.createSimple()
				.addClass(TrackDetailsCtrlr.class);
	}
	
	@Inject
	private TrackDetailsCtrlr ctrlr;
	
	@Test
	public void test() {
		ctrlr.dummy();
		assertThat(ctrlr.getTrack().getName()).isEqualTo("dummy track");
	}
}

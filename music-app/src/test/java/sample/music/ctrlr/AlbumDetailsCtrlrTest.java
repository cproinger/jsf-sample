package sample.music.ctrlr;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import sample.TestUtils;
import sample.common.EntityManagerProducer;
import sample.music.domain.Album;
import sample.music.repo.AlbumRepository;

@RunWith(Arquillian.class)
public class AlbumDetailsCtrlrTest {
	
	private class FakeAlbumRepository implements AlbumRepository {

		@Override
		public List<Album> findAll(String loadgraph) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Album> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Album findById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Album findById(Integer id, String loadgraph) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Album> findByArtistId(Integer artistId) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	@Deployment
	public static WebArchive createApp() {
		return TestUtils.createSimple()
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addClass(EntityManagerProducer.class)
				.addClass(FakeAlbumRepository.class)
				.addClass(AlbumDetailsCtrlr.class)
				;
	}

	@Inject
	private AlbumDetailsCtrlr ctrlr;
	
	@Test
	@Ignore
	public void test() {
		ctrlr.setAlbumId(4);
		ctrlr.onLoad();
	}
}

package sample;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class TestUtils {

	public static WebArchive createSimple() {
//		MavenR
		return ShrinkWrap.create(WebArchive.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
//				.addAsLibraries(archives)
				;
	}

}

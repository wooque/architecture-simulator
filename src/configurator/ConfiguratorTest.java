package configurator;

import org.junit.Test;

public class ConfiguratorTest {

	@Test
	public void testMain() {
		new Configurator("schemes.conf");
	}

}

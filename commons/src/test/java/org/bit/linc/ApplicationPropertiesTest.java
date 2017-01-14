package org.bit.linc;

import static org.junit.Assert.*;

import org.apache.commons.configuration.Configuration;
import org.junit.Test;

public class ApplicationPropertiesTest {

	@Test
	public void ConfigurationTest() throws SysimpleException{
		Configuration configuration=ApplicationProperties.get();
		int test=configuration.getInt("sysimple.webserver.minthreads");
		System.out.println(test);
	}

}

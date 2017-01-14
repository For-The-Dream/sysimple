package org.bit.linc;


import org.apache.commons.configuration.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationPropertiesTest {

	@Test
	public void ConfigurationTest() throws SysimpleException{
		Configuration configuration=ApplicationProperties.get();
		int test=configuration.getInt("sysimple.webserver.minthreads");
		Assert.assertEquals(test, 1000);
	}

}

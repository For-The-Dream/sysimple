package org.bit.linc.util;

import static org.junit.Assert.*;

import java.util.List;

import org.bit.linc.SysimpleException;
import org.junit.Assert;
import org.junit.Test;

public class PluginUtilTest {

	@Test
	public void pluginList() {
		List<String> lists=PluginUtil.pluginList();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void shellList() throws SysimpleException {
		List<String> lists=PluginUtil.shellList("basic-plugins");
		Assert.assertNotNull(lists);
	}

}

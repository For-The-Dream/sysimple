package org.bit.linc;

import java.io.File;
import java.net.URL;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ApplicationProperties extends PropertiesConfiguration{
	public static String SYSIMPLE_PROPERTIES="sysimple.properties";
	
	private static volatile Configuration instance = null;
	
	public ApplicationProperties(URL url) throws ConfigurationException{
		super(url);
	}
	public static Configuration get() throws SysimpleException{
        if (instance == null) {
            synchronized (ApplicationProperties.class) {
                if (instance == null) {
                    instance = get(SYSIMPLE_PROPERTIES);
                }
            }
        }
        return instance;
    }

    public static Configuration get(String fileName) throws SysimpleException{
        String confLocation = System.getProperty("sysimple.conf");
        try {
            URL url = null;

            if (confLocation == null) {

                url = ApplicationProperties.class.getClassLoader().getResource(fileName);

                if (url == null) {
                	//find file from classpath
                    url = ApplicationProperties.class.getClassLoader().getResource("/" + fileName);
                }
            } else {
                url = new File(confLocation, fileName).toURI().toURL();
            }
            Configuration configuration = new ApplicationProperties(url).interpolatedConfiguration();
            return configuration;
        } catch (Exception e) {
            throw new SysimpleException("Failed to load application properties", e);
        }
    }
    /**
     * 去配置的前缀，如prefix为prefix,则<br/> 
     * &nbsp;&nbsp;  prefix.number = 1<br/> 
     * &nbsp;&nbsp;  prefix.string = Apache<br/> 
     * &nbsp;&nbsp;  prefixed.foo = bar<br/> 
     * &nbsp;&nbsp;  prefix = Jakarta<br/> 
     * 会返回如下配置项<br/> 
     * &nbsp;&nbsp;  number = 1<br/> 
     * &nbsp;&nbsp;  string = Apache<br/> 
     * &nbsp;&nbsp;  = Jakarta<br/> 

     * @param inConf
     * @param prefix &nbsp;需要去除的前缀
     * @return
     */
    public static Configuration getSubsetConfiguration(Configuration inConf, String prefix) {
        return inConf.subset(prefix);
    }
    
    
}

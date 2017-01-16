package org.bit.linc;

import org.apache.commons.configuration.Configuration;

public enum SysimpleConfiguration {
	
	//这里可以添加属性和默认值如
	WEBSERVER_MIN_THREADS("sysimple.webserver.minthreads", 10),
	WEBSERVER_MAX_THREADS("sysimple.webserver.maxthreads", 100);
	
	private static final Configuration SYSIMPLE_PROPERTIES;

    static {
        try {
        	SYSIMPLE_PROPERTIES = ApplicationProperties.get();
        } catch (SysimpleException e) {
            throw new RuntimeException(e);
        }
    }

    private final String propertyName;
    private final Object defaultValue;

    SysimpleConfiguration(String propertyName, Object defaultValue) {
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    public int getInt() {
        return SYSIMPLE_PROPERTIES.getInt(propertyName, Integer.valueOf(defaultValue.toString()).intValue());
    }

    public long getLong() {
        return SYSIMPLE_PROPERTIES.getLong(propertyName, Long.valueOf(defaultValue.toString()).longValue());
    }

    public String getString() {
        return SYSIMPLE_PROPERTIES.getString(propertyName, defaultValue.toString());
    }

    
    public Object get() {
        Object value = SYSIMPLE_PROPERTIES.getProperty(propertyName);
        return value == null ? defaultValue : value;
    }
}

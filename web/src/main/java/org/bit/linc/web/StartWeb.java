package org.bit.linc.web;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartWeb {
	public static void main(String[] args) {
		Server server = new Server();
		 // ������JVM�˳�ʱ�ر�Jetty�Ĺ��ӡ�
		 server.setStopAtShutdown(true);
		SelectChannelConnector connector = new SelectChannelConnector();
		 // ���Windows���ظ�����Jetty��Ȼ������˿ڳ�ͻ������.
		connector.setReuseAddress(false);
        connector.setPort(3000);
        server.setConnectors(new Connector[] { connector }); 
        WebAppContext webAppContext = new WebAppContext("src/main/webapp","/");
        webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        webAppContext.setResourceBase("src/main/webapp");
        webAppContext.setDisplayName("jetty");
        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        webAppContext.setConfigurationDiscovered(true);
        webAppContext.setParentLoaderPriority(true);
        server.setHandler(webAppContext);
         
        try{
            server.start();
        }catch(Exception e){
        }
	}

}

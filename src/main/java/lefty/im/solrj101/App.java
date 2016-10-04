package lefty.im.solrj101;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lefty.im.solrj101.config.SOLRCore;
import lefty.im.solrj101.config.SOLRServer;

/**
 * Hello world!
 *
 */
public class App {
	private final static Logger slf4jLogger = LoggerFactory.getLogger( App.class);

	public static void main(String[] args) {
		

//		Utils101.connectAndQuery();
		//String SOLR_URL = "http://ec2-52-11-184-249.us-west-2.compute.amazonaws.com";
		
		//GetCores.getCores(SOLR_URL, 8983);
		
		SOLRServer server = new SOLRServer("Apollo","http://ec2-52-11-184-249.us-west-2.compute.amazonaws.com",8983);
		
		
		if (server.buildCoreList()){
			ArrayList<SOLRCore> listCores= server.getCores();
			for (SOLRCore c:listCores){
				System.out.println(c.getMyName()+"-"+c.getName());
				System.out.println("Config: "+c.getConfig());
				System.out.println("Start time: "+c.getStartTime());
				System.out.println("Uptime: "+c.getUptime());
			}
			
		}
		else{
			slf4jLogger.error("Failed to detect cores");
		}

	}

}

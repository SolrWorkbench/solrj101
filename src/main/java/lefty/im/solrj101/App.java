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
		GetCores.getCores();
		
		SOLRServer server = new SOLRServer("Apollo","",8983);
		if (server.buildCoreList()){
			ArrayList<SOLRCore> listCores= server.getCores();
			for (SOLRCore c:listCores){
				System.out.println(c.getMyName()+"-"+c.getName());
			}
			
		}
		else{
			slf4jLogger.error("Failed to detect cores");
		}

	}

}

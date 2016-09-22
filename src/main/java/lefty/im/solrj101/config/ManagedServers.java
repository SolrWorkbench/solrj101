package lefty.im.solrj101.config;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final public class ManagedServers {
	private final static Logger logger = LoggerFactory.getLogger( ManagedServers.class);

	// make constructor private
	private ManagedServers(){
		
	}
	static private ArrayList<SOLRServer> managedServers = new ArrayList<SOLRServer>();
	
	public static Boolean ReadServerDataFromConfig(){
		
		logger.debug("ManagedServers.ReadServerDataFromConfig");
		// forget previous status
		managedServers = new ArrayList<SOLRServer>();
		
		SOLRServer s = new SOLRServer("helyben","localhost",8983);

		// helyben
		ArrayList<SOLRCore> listCore = s.getCores();
		listCore.add(new SOLRCore("SMT"));
		listCore.add(new SOLRCore("ADVSRC"));
		listCore.add(new SOLRCore("CQTTST"));
		listCore.add(new SOLRCore("jcg"));
		listCore.add(new SOLRCore("jcg2"));
		listCore.add(new SOLRCore("jjccgg"));
		listCore.add(new SOLRCore("networklocations"));
		listCore.add(new SOLRCore("smt_network_fl2"));
		listCore.add(new SOLRCore("smt_network_hierarchy"));
		managedServers.add(s);
		
		// Artemis
		s = new SOLRServer("Artemis","ec2-52-25-150-78.us-west-2.compute.amazonaws.com",8983);
		managedServers.add(s);

		// Apollo
		s = new SOLRServer("Apollo","ec2-52-11-184-249.us-west-2.compute.amazonaws.com",8983);
		managedServers.add(s);


		// dev
		s = new SOLRServer("dev","ec2-52-37-229-78.us-west-2.compute.amazonaws.com",8983);
		managedServers.add(s);

		
		return true;
	}
	
	public static Boolean WriteServerData2Config(){
		return true;
	}

	public static ArrayList<SOLRServer> getManagedServers() {
		logger.debug("ManagedServers.getManagedServers");
		return managedServers;
	}

	public static void setManagedServers(ArrayList<SOLRServer> managedServers) {
		ManagedServers.managedServers = managedServers;
	}
	
}

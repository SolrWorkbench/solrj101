package lefty.im.solrj101.config;

import java.util.ArrayList;

public class ManagedServers {

	private ArrayList<SOLRServer> managedServers = new ArrayList<SOLRServer>();
	
	Boolean ReadServerDataFromConfig(){
		SOLRServer s = new SOLRServer("localhost",8983);
		
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
		return true;
	}
	
	Boolean WriteServerData2Config(){
		return true;
	}
	
}

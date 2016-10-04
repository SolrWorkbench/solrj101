package lefty.im.solrj101.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;
import org.apache.solr.client.solrj.response.RangeFacet.Date;
import org.apache.solr.common.params.CoreAdminParams.CoreAdminAction;

public class SOLRServer {
	// URL or IP address of the server
	private String dnsName="";
	private int myPortNumber=1983;
	// Human name of the server
	private String myHumanName="";
	private ArrayList<SOLRCore> cores = new ArrayList<SOLRCore>();  
	
	public SOLRServer(String serverName){
		dnsName=serverName;
		myPortNumber=8983;
	}
	
	public SOLRServer(String dnsName, int port){
		dnsName=dnsName;
		myPortNumber=port;
		myHumanName=dnsName;
	}

	public SOLRServer(String humanName,String serverName, int port){
		dnsName=serverName;
		myPortNumber=port;
		myHumanName=humanName;
	}

	
	/**
	 * detects the SOLR cores of the server
	 * 
	 * if dnsName=="" return false
	 * in case of any exception return false
	 * 
	 * NOTE: initialize the human name of the core with the technical name (User will be able to edit it on the GUI)!
	 * 
	 * @return 
	 *    true : if server can be reached and cores read in; private ArrayList<SOLRCore> cores is replaced by the resulted list
	 *    false: in case of any problem; private ArrayList<SOLRCore> cores   is left unchanged
	 */
	public boolean buildCoreList(){
		
			String fullUrl = dnsName + ":" + myPortNumber + "/solr/";
			CoreAdminResponse cores = null;
			HttpSolrClient solrClient = new HttpSolrClient.Builder(fullUrl).build();
			CoreAdminRequest request = new CoreAdminRequest();
			request.setAction(CoreAdminAction.STATUS);

			try {
				cores = request.process(solrClient);
				
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Listing cores");
			List<String> coreList = new ArrayList<String>();
			for (int i = 0; i < cores.getCoreStatus().size(); i++) {
				
				String name=cores.getCoreStatus().getName(i);
				
				String coreStatus=cores.getCoreStatus(name).toString();
				
				System.out.println(name);
				System.out.println(coreStatus);

						
				SOLRCore newCore = new SOLRCore(name);
				String config = (String) cores.getCoreStatus(name).get("config");
				String datadir = cores.getCoreStatus(name).get("dataDir").toString();
				//CoreIndex index = (CoreIndex) cores.getCoreStatus(name).get("index");
				String instanceDir = cores.getCoreStatus(name).get("instanceDir").toString();
				//String myName = null;
				//String localName = null;
				String schema = cores.getCoreStatus(name).get("schema").toString();
				String kickoffTime = cores.getCoreStatus(name).get("startTime").toString();
				String uptime = cores.getCoreStatus(name).get("uptime").toString();
				//CoreUserData userData = (CoreUserData) cores.getCoreStatus(name).get("userData");
				
				newCore.setConfig(config);
				newCore.setDatadir(datadir);
				//newCore.setIndex(index);
				newCore.setInstanceDir(instanceDir);
				//newCore.setMyName(myName);
				///newCore.setName(localName);
				newCore.setSchema(schema);
				newCore.setStartTime(kickoffTime);
				newCore.setUptime(uptime);
				//newCore.setUserData(userData);
				
				
				
				this.cores.add(newCore);
				}
			
					
		return true;
	}
	
	
	public String getDNSName() {
		return dnsName;
	}
	public void setDNSName(String dnsName) {
		this.dnsName = dnsName;
	}
	public int getPortNumber() {
		return myPortNumber;
	}
	public void setPortNumber(int myPortNumber) {
		this.myPortNumber = myPortNumber;
	}
	public String getHumanName() {
		return myHumanName;
	}
	public void setHumanName(String myHumanName) {
		this.myHumanName = myHumanName;
	}
	public ArrayList<SOLRCore> getCores() {
		return cores;
	}
	public void setCores(ArrayList<SOLRCore> cores) {
		this.cores = cores;
	}
	

}

package lefty.im.solrj101.config;

import java.util.ArrayList;

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
		ArrayList<SOLRCore> detectedCores= new ArrayList<SOLRCore>();
		
		// TODO enter code here
		
		
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

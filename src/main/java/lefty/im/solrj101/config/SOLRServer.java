package lefty.im.solrj101.config;

import java.util.ArrayList;

public class SOLRServer {
	// URL or IP address of the server
	private String dnsName;
	private int myPortNumber;
	// Human name of the server
	private String myHumanName;
	private ArrayList<SOLRCore> cores = new ArrayList<SOLRCore>();  
	
	SOLRServer(String serverName){
		dnsName=serverName;
		myPortNumber=8983;
	}
	
	SOLRServer(String dnsName, int port){
		dnsName=dnsName;
		myPortNumber=port;
		myHumanName=dnsName;
	}

	SOLRServer(String humanName,String serverName, int port){
		dnsName=serverName;
		myPortNumber=port;
		myHumanName=humanName;
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

package lefty.im.solrj101.config;

import java.util.ArrayList;

public class SOLRServer {
	// URL or IP address of the server
	private String myServerName;
	private int myPortNumber;
	// Human name of the server
	private String myHumanName;
	private ArrayList<SOLRCore> cores = new ArrayList<SOLRCore>();  
	
	SOLRServer(String serverName){
		myServerName=serverName;
		myPortNumber=8983;
	}
	
	SOLRServer(String serverName, int port){
		myServerName=serverName;
		myPortNumber=port;
	}
	
	public String getServerName() {
		return myServerName;
	}
	public void setServerName(String myServerName) {
		this.myServerName = myServerName;
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

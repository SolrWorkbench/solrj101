package lefty.im.solrj101.config.controls;

import lefty.im.solrj101.config.SOLRServer;

public class NodeServer {
	
	private String serverHumanName;
	private String nodeIcon;

	public NodeServer(String nIcon, String humanName){
		nodeIcon=nIcon;
		serverHumanName=humanName;
	}


	public String getNodeIcon() {
		return nodeIcon;
	}

	public void setNodeIcon(String nodeIcon) {
		this.nodeIcon = nodeIcon;
	}


	public String getServerHumanName() {
		return serverHumanName;
	}


	public void setServerHumanName(String serverHumanName) {
		this.serverHumanName = serverHumanName;
	}
}

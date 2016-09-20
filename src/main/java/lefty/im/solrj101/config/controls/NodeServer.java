package lefty.im.solrj101.config.controls;

import lefty.im.solrj101.config.SOLRServer;

public class NodeServer {
	
	private SOLRServer representedSOLRServer;
	private String nodeIcon;

	public NodeServer(String nIcon, SOLRServer representedSrv){
		nodeIcon=nIcon;
		representedSOLRServer=representedSrv;
	}

	public SOLRServer getRepresentedSOLRServer() {
		return representedSOLRServer;
	}

	public void setRepresentedSOLRServer(SOLRServer representedSOLRServer) {
		this.representedSOLRServer = representedSOLRServer;
	}

	public String getNodeIcon() {
		return nodeIcon;
	}

	public void setNodeIcon(String nodeIcon) {
		this.nodeIcon = nodeIcon;
	}
}

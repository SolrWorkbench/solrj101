package lefty.im.solrj101.config;

public class SOLRCore {
	private String myName;
	
	SOLRCore(String coreName){
		myName=coreName;
	}
	
	public String getName() {
		return myName;
	}

	public void setName(String myName) {
		this.myName = myName;
	}

}

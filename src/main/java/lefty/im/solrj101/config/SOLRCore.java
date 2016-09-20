package lefty.im.solrj101.config;

public class SOLRCore {
	private String myName; // human name of the core
	
	String name; // technical name of the core on the server
	String instanceDir;
	String datadir;
	String config;
	String schema;
	String startTime;
	String uptime;
	CoreIndex index;
	CoreUserData userData;
	
	
	
	
	SOLRCore(String coreName){
		myName=coreName;
	}
	
	public String getName() {
		return myName;
	}

	public void setName(String myName) {
		this.myName = myName;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getInstanceDir() {
		return instanceDir;
	}

	public void setInstanceDir(String instanceDir) {
		this.instanceDir = instanceDir;
	}

	public String getDatadir() {
		return datadir;
	}

	public void setDatadir(String datadir) {
		this.datadir = datadir;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public CoreIndex getIndex() {
		return index;
	}

	public void setIndex(CoreIndex index) {
		this.index = index;
	}

	public CoreUserData getUserData() {
		return userData;
	}

	public void setUserData(CoreUserData userData) {
		this.userData = userData;
	}

}

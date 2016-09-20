package lefty.im.solrj101.config;

public class CoreUserData {
	private String commitTimeMSec;
	private String lastModified; 
	private long sizeInBytes;
	private String size;
	public String getCommitTimeMSec() {
		return commitTimeMSec;
	}
	public void setCommitTimeMSec(String commitTimeMSec) {
		this.commitTimeMSec = commitTimeMSec;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public long getSizeInBytes() {
		return sizeInBytes;
	}
	public void setSizeInBytes(long sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}

package lefty.im.solrj101.config;

public class CoreIndex {
	private int numDocs;
	private int maxDoc;
	private int deletedDocs;
	private long indexHeapUsageBytes;
	private long version;
	private int segmentCount;
	private boolean current;
	private boolean hasDeletions;
	private String directory;
	
	public int getNumDocs() {
		return numDocs;
	}
	public void setNumDocs(int numDocs) {
		this.numDocs = numDocs;
	}
	public int getMaxDoc() {
		return maxDoc;
	}
	public void setMaxDoc(int maxDoc) {
		this.maxDoc = maxDoc;
	}
	public int getDeletedDocs() {
		return deletedDocs;
	}
	public void setDeletedDocs(int deletedDocs) {
		this.deletedDocs = deletedDocs;
	}
	public long getIndexHeapUsageBytes() {
		return indexHeapUsageBytes;
	}
	public void setIndexHeapUsageBytes(long indexHeapUsageBytes) {
		this.indexHeapUsageBytes = indexHeapUsageBytes;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public int getSegmentCount() {
		return segmentCount;
	}
	public void setSegmentCount(int segmentCount) {
		this.segmentCount = segmentCount;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
	public boolean isHasDeletions() {
		return hasDeletions;
	}
	public void setHasDeletions(boolean hasDeletions) {
		this.hasDeletions = hasDeletions;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	
	
	
}

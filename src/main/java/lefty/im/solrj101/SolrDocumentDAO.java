
package lefty.im.solrj101;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrDocumentDAO {
	
	
	
	

	String urlString;
	
	
	
	SolrClient solr;
	SolrQuery query;
	String mQueryString;

	/**
	 * @param urlString
	 * @param solr
	 * @param query
	 * @param mQueryString
	 */
	public SolrDocumentDAO(String urlString, SolrClient solr, SolrQuery query, String mQueryString) {
		super();
		this.urlString = urlString;
		this.solr = solr;
		this.query = query;
		this.mQueryString = mQueryString;
	}

	/**
	 * @param urlString
	 * @param mQueryString
	 */
	public SolrDocumentDAO(String urlString, String mQueryString) {
		super();
		this.urlString = urlString;
		this.mQueryString = mQueryString;
	}

	/**
	 * 
	 */
	public SolrDocumentDAO() {
		super();
	}

	

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	public SolrClient getSolr() {
		return solr;
	}

	public void setSolr(SolrClient solr) {
		this.solr = solr;
	}

	public SolrQuery getQuery() {
		return query;
	}

	public void setQuery(SolrQuery query) {
		this.query = query;
	}

	public String getmQueryString() {
		return mQueryString;
	}

	public void setmQueryString(String mQueryString) {
		this.mQueryString = mQueryString;
	}

}

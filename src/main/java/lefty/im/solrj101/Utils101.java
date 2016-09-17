package lefty.im.solrj101;

import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.CoreAdminParams.CoreAdminAction;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;


class Utils101 {
	
	static String APOLLO = "http://ec2-52-11-184-249.us-west-2.compute.amazonaws.com:8983/solr/";
	
	public static void connectAndQuery() {
		try {

            String urlString = "http://ec2-52-11-184-249.us-west-2.compute.amazonaws.com:8983/solr/hellosolr";
            SolrClient solr = new HttpSolrClient.Builder(urlString).build();
            System.out.println("connection built");

//        solr.setParser(new XMLResponseParser());
            SolrQuery query = new SolrQuery();
            String mQueryString = "cat:memory";
            query.setQuery(mQueryString);
            System.out.println("query set");
            QueryResponse response = solr.query(query);
            SolrDocumentList list = response.getResults();
            System.out.println("responses collected");
            System.out.println(             list.get(0).toString());
        } catch (SolrServerException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public static void getCores() {
		System.out.println("Solr server instance building Apollo");
		
		HttpSolrClient solrClient=new HttpSolrClient.Builder(APOLLO).build();

		System.out.println("Requesting core list"); 
		CoreAdminRequest request = new CoreAdminRequest();
		request.setAction(CoreAdminAction.STATUS);
		CoreAdminResponse cores=null;
		
		try {
			cores = request.process(solrClient);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> list = new ArrayList<String>();
	    
		System.out.println(" Listing cores");
		List<String> coreList = new ArrayList<String>();
		for (int i = 0; i < cores.getCoreStatus().size(); i++) {
		    coreList.add(cores.getCoreStatus().getName(i));
		}
		
		System.out.println(coreList.get(0)+" is the first core");

	}
	
}

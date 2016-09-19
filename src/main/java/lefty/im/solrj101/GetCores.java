package lefty.im.solrj101;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;
import org.apache.solr.common.params.CoreAdminParams.CoreAdminAction;

public class GetCores {
	static String SOLR_URL = "http://ec2-52-11-184-249.us-west-2.compute.amazonaws.com:8983/solr/";

	public static void getCores() {
		System.out.println("Building Solr server instance");
		HttpSolrClient solrClient=new HttpSolrClient.Builder(SOLR_URL).build();

		System.out.println("Requesting core list"); 
		CoreAdminRequest request = new CoreAdminRequest();
		request.setAction(CoreAdminAction.STATUS);
		CoreAdminResponse cores=null;
		
		try {
			cores = request.process(solrClient);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		System.out.println(" Listing cores");
		List<String> coreList = new ArrayList<String>();
		for (int i = 0; i < cores.getCoreStatus().size(); i++) {
		    coreList.add(cores.getCoreStatus().getName(i));
		}
		
		System.out.println(coreList.get(0)+" is the first core");

	}

	
}

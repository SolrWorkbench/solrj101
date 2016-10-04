package lefty.im.solrj101;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;
import org.apache.solr.common.params.CoreAdminParams.CoreAdminAction;

import lefty.im.solrj101.config.SOLRCore;

public class GetCores {

	public static void getCores(String solrUrl, int port) {
		String fullUrl = solrUrl + ":" + port + "/solr/";
		CoreAdminResponse cores = null;
		ArrayList<SOLRCore> detectedCores= new ArrayList<SOLRCore>();

		System.out.println("Building Solr server instance");
		HttpSolrClient solrClient = new HttpSolrClient.Builder(fullUrl).build();

		System.out.println("Requesting core list");
		CoreAdminRequest request = new CoreAdminRequest();
		request.setAction(CoreAdminAction.STATUS);
//		request.setAction(CoreAdminAction.STATUS);
		
		
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
			 System.out.println(cores.getRequestUrl()+" "+cores.getElapsedTime());
		}
		
		

		System.out.println(coreList.get(0) + " is the first core");
		System.out.println(coreList.get(1) + " is the second core");
		System.out.println(coreList.get(2) + " is the third core");
		

	}

}

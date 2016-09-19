package lefty.im.solrj101.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Explorer {
	
	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:8983/solr/SMT/select?q=*%3A*&wt=json&indent=true");
		HttpResponse response=null;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Get the response
		BufferedReader rd = null;
		try {
			rd = new BufferedReader
			  (new InputStreamReader(response.getEntity().getContent()));
		} catch (UnsupportedOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    
		String line = "";
		try {
			while ((line = rd.readLine()) != null) {
			  //textView.append(line);
				System.out.println("|"+line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	ArrayList<SOLRCore> ExploreCores(SOLRServer server) {

		return null;

	}

}

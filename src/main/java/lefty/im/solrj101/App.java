package lefty.im.solrj101;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

//import org.apache.solr.client.solrj.impl.XMLResponseParser;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {

            String urlString = "http://ec2-52-11-184-249.us-west-2.compute.amazonaws.com:8983/solr/techproducts";
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
        } catch (SolrServerException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }
}

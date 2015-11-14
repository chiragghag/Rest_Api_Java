import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import java.net.URLEncoder;
import java.lang.Character;
/**
 * This class is the same as the ApacheHttpRestClient2 class, but with
 * fewer try/catch clauses, and fewer comments.
*/
public class ApacheHttpRestClient3 {
 
  public final static void main(String[] args) {
     
    
    try {
    	DBnamephonenum testdb=new DBnamephonenum();
    	List<agent> agentlist= new ArrayList<agent>();
        agentlist=testdb.getagents();
    	for(agent agent:agentlist){
    		HttpClient httpClient = new DefaultHttpClient();
    		String name=URLEncoder.encode(agent.getName(), "UTF-8").replaceAll("\\+", "%20");
    		System.out.println(java.net.URLEncoder.encode(agent.getName(), "UTF-8").replaceAll("\\+", "%20"));
    		System.out.println("inside main for number"+name+"--------"+agent.getNumber());
    	String msg="Hi%20"+name+"%20please%20refresh%20your%20properties%20on%20K-Exchange%20Android%20APP.%20Next%20issue%20on%2008%20July%2015";
    	HttpPost test = new HttpPost("http://www.wesendsms.com/sms/send_api_msg.php?sender=#unique_key#&destination="+agent.getNumber()+"&message="+msg+"&send=#userid#");
    	 HttpResponse httpResponse = httpClient.execute(test);
    	 
    	 System.out.println("----------------------------------------");
         System.out.println(httpResponse.getStatusLine());
         System.out.println("----------------------------------------");
       
         httpClient.getConnectionManager().shutdown();
    	}
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
        httpClient.getConnectionManager().shutdown();
    }
  }
}
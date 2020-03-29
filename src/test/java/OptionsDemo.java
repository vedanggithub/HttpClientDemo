import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.io.IOException;

public class OptionsDemo {
    public static final String BASE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    @Test
    public void getEndpoint() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating a HttpGet object
        HttpOptions httpget = new HttpOptions(BASE_ENDPOINT + "users");

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);
        System.out.println(getHeaders(httpresponse,"Access-Control-Allow-Methods"));
        //System.out.println(httpresponse.getAllHeaders().toString());

    }
    public Header getHeaders(HttpResponse httpresponse , String head){
        Header[] headers = httpresponse.getAllHeaders();
        for (Header header : headers) {
            if(header.getName().equals(head))
                return header;
        }
        return null;
    }
}

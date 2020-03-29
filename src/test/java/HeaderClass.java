import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HeaderClass
{
    public static final String BASE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    @Test
    public void getEndpoint() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating a HttpGet object
        HttpGet httpget = new HttpGet(BASE_ENDPOINT+"users");

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);
       // int code= httpresponse.getStatusLine().getStatusCode();
        Header content=httpresponse.getEntity().getContentType();
        Assert.assertEquals(content.getValue(),"application/json; charset=utf-8");
    }
}

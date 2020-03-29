import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EntityDemo {
    public static final String BASE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    @Test
    public void getEndpoint() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating a HttpGet object
        HttpGet httpget = new HttpGet(BASE_ENDPOINT+"users");

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);

        String json= EntityUtils.toString(httpresponse.getEntity());
        System.out.println(json);

        int code= httpresponse.getStatusLine().getStatusCode();
        Assert.assertEquals(code,200);
    }
}

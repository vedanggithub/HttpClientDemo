import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetClass {

    public static final String BASE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    public static void main(String[] args) throws IOException {
        GetClass gc=new GetClass();
      //  gc.endpoints();
        gc.getEndpoint();
       // gc.getuserData();
    }
public void getEndpoint() throws IOException {
        //int a=2;
    CloseableHttpClient httpclient = HttpClients.createDefault();

    //Creating a HttpGet object
    HttpGet httpget = new HttpGet(BASE_ENDPOINT);

    //Executing the Get request
    HttpResponse httpresponse = httpclient.execute(httpget);
    int code= httpresponse.getStatusLine().getStatusCode();
        Assert.assertEquals(code,200);
}

@Test(dataProvider = "endpoints")
public void getuserData(String endpoint) throws IOException {

    CloseableHttpClient httpclient = HttpClients.createDefault();
    //Creating a HttpGet object
    HttpGet httpget = new HttpGet(BASE_ENDPOINT+endpoint);
    //Printing the method used
    // System.out.println("Request Type: "+httpget.getMethod());
    //Executing the Get request
    HttpResponse httpresponse = httpclient.execute(httpget);
    System.out.println(httpresponse.getEntity().getContent());
    int code= httpresponse.getStatusLine().getStatusCode();
    Assert.assertEquals(code,200);
}
@DataProvider
public Object[][] endpoints(){
        return new Object[][]{
        {"/posts"},
        {"/comments"},
        {"/albums"},
        {"/photos"},
        {"/todos"},
        {"/users"}
        };
    }

}

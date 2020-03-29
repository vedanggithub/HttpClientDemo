import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class PostDemo {

    //public static final String BASE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    @Test
    public void getEndpoint() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //Creating a HttpGet object
        HttpPost httppost = new HttpPost("https://api.github.com/user/repos");
        String auth=Credentials.getEmail()+":"+Credentials.getPassWard();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader="Basic "+new String(encodedAuth);
        httppost.setHeader(HttpHeaders.AUTHORIZATION,authHeader);
        String json="{\"name\": \"ploiko\"}";
        httppost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        HttpResponse httpresponse = httpclient.execute(httppost);
        System.out.println(httpresponse.getStatusLine());
        int actual=httpresponse.getStatusLine().getStatusCode();
        Assert.assertEquals(actual,201);
        //System.out.println(getHeaders(httpresponse,"Access-Control-Allow-Methods"));
        //System.out.println(httpresponse.getAllHeaders().toString());

    }
}

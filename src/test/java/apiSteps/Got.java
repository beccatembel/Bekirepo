package apiSteps;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Got {

    @Test
    public void getTest() throws URISyntaxException, IOException {
        //launch a client
        HttpClient client= HttpClientBuilder.create().build();

        //construct an endpoint
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("the-one-api.dev");
        uriBuilder.setPath("v2/book");

        //Define http method
        HttpGet get=new HttpGet(uriBuilder.build());

        //define headers
        get.setHeader("accept","application/json");

        //execute request/click sen button
        HttpResponse response=client.execute(get);


        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(200,response.getStatusLine().getStatusCode() );
    }

}

package apiSteps;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.net.URISyntaxException;

public class PetStore {
    @Test
    public void petTest() throws URISyntaxException {

        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/findByStatus");
        uriBuilder.setParameter("status","sold");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("accept","application/json");

        System.out.println();

    }
}

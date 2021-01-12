package Deserilization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;

public class IntroDeserilize {

    @Test

    public void Reqres() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("/api/users");
        uriBuilder.setParameter("page", "2");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("accept","application/json");

        HttpResponse response = client.execute(httpGet);

        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());

        //Deserilizing the response
        ObjectMapper objectMapper=new ObjectMapper();
        InputStream responsBody=response.getEntity().getContent();
        Map<String,Object> parseResponse=objectMapper.readValue(responsBody, new TypeReference<Map<String,Object>>() {
        });

        int pageNum=(int)parseResponse.get("page");
        int perPage=(int)parseResponse.get("per_page");
        int total=(int)parseResponse.get("total");
        int total_pages=(int)parseResponse.get("total_pages");

        System.out.println(parseResponse.get("page"));
        System.out.println(parseResponse.get("per_page"));
        System.out.println(parseResponse.get("total"));
        System.out.println(parseResponse.get("total_pages"));

        Map<String,String>adValues=(Map<String,String>)parseResponse.get("support");
        System.out.println(adValues.get("url"));




    }
}

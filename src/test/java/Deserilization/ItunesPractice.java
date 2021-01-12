package Deserilization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class ItunesPractice {
    @Test
    public void getItunesTest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com");
        uriBuilder.setPath("search");
        uriBuilder.setParameter("term", "green day");
        uriBuilder.setParameter("limit","14");
        HttpGet getMethod = new HttpGet(uriBuilder.build());
        getMethod.setHeader("accept", "application/json");


        HttpResponse response = client.execute(getMethod);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parsedResp = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        int resultCount = (int) parsedResp.get("resultCount");

        List<Map<String, Object>> songList = (List<Map<String, Object>>) parsedResp.get("results");
        Assert.assertEquals(resultCount, songList.size());



    }
}

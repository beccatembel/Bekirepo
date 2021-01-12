package restAssured;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javafx.beans.binding.ObjectBinding;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StarWars {
    @Test
    public void planetTest(){
        Response response=given().accept(ContentType.JSON).when().get("https://swapi.dev/api/planets")
                .then().statusCode(200).and().contentType(ContentType.JSON).extract().response();

      Map<String,Object>parsedresp=  response.as(new TypeRef<Map<String,Object>>() {
        });
      List<Map<String, Object>> resultList=( List<Map<String, Object>>)parsedresp.get("results");

      for(int i=0;i<resultList.size();i++){
          Map<String,Integer>planetWithPopulation=new HashMap<>();
          String planetname=resultList.get(i).get("name").toString();
          int population;
          try {
               population = Integer.parseInt(resultList.get(i).get("population").toString());
          }catch(NumberFormatException ex){
              population=0;
          }
          planetWithPopulation.put(planetname,population);
         // System.out.println("Planet name: " +planetname+ " population "+population);
          System.out.println(planetWithPopulation);
      }
    }
}

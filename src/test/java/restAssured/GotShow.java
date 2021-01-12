package restAssured;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GotShow {
    @Test
    public void GotCharacters() {


        Map<String, Object> resp = given().accept(ContentType.JSON).when()
                .get("https://api.got.show/api/map/characters/")
                .then().statusCode(200).contentType(ContentType.JSON)
                .extract().as(new TypeRef<Map<String, Object>>() {
                });

      List<Map<String,Object>> characters= (List<Map<String,Object>>)resp.get("data");
      int count=0;
      for(int i=0;i<characters.size();i++){
         List<String>books= (List<String>)characters.get(i).get("books");
         if(books.contains("The World of Ice and Fire")){
             count++;
             System.out.println(characters.get(i).get("name"));

         }

      }
        System.out.println(count);
        Assert.assertEquals(165,  count );
       //resp.get("books").equals("The World of Ice and Fire");

    }
}

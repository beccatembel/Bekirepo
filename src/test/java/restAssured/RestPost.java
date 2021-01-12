package restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class RestPost {
    @Test
    public void postTest(){

        RestAssured.baseURI="https://qeenv-apihr-arslan.herokuapp.com";
        RestAssured.basePath="/api/employees/203";
        File requestBody=new File("src/test/java/serilization/empl.json");

        RequestSpecification reqSpec=given().accept(ContentType.JSON);
        ResponseSpecification reqSpec2=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
        .expectBody("firstName", Matchers.equalTo("Susan"))
                .expectBody("department.departmentId",Matchers.equalTo(40))
                .expectBody("location.locationCity",Matchers.equalTo("London"))
                .build();

       Response postresponse= reqSpec.contentType(ContentType.JSON).body(requestBody)
                .post().then().spec(reqSpec2).log().all().extract().response();

       Response getresponse=reqSpec.when()
               .get("/203").then().spec(reqSpec2).time(Matchers.lessThan(1l), TimeUnit.SECONDS).extract().response();


    }
}

package restAssured;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssured {
    @Before
    public void setUp(){
        io.restassured.RestAssured.baseURI="https://qeenv-apihr-arslan.herokuapp.com";
        io.restassured.RestAssured.basePath="/api/employees";
    }
    @Test
    public void restGetTest(){

        given().accept("application/json")
                .when().get("/203").then()
                .assertThat().statusCode(200).log().ifValidationFails();

    }

    @Test
    public void passgetTest(){

        Response response=given().accept("application/json")
                .when().get("/203").then()
                .assertThat().statusCode(200).extract().response();

        //deserilization starts here
        //in order to do so ,we have to put my data driven format into Response.
        response.then().contentType(ContentType.JSON).and().body("firstName", Matchers.equalTo("Susan"))
                .and().body("department.departmentId",Matchers.equalTo(40));
    }

    @Test
    public void department(){
        Response response=given().accept("application/json")
                .when().get("/100").then()
                .assertThat().statusCode(200).extract().response();

        response.then().contentType(ContentType.JSON).and().body("firstName",Matchers.equalTo("Steven"))
                .and().body("job.title",Matchers.equalTo("President"));
    }

    @Test
    public void restGet(){
        given().accept("application/json").when().get("https://qeenv-apihr-arslan.herokuapp.com/api/employees")
                .then().statusCode(200);
    }
}

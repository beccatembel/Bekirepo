package restAssured;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deserilization {

    @Test
    public void deserilizationWith() {
        Map<String, Object> parsedRes = given().accept(ContentType.JSON).when()
                .get("https://qeenv-apihr-arslan.herokuapp.com/api/employees")
                .then().statusCode(200).extract().as(new TypeRef<Map<String, Object>>() {
                });

    }}

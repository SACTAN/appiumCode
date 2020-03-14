package com.airtel;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.filter.session.SessionFilter;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class JiraSsession {

    public static void main(String[] arg)
    {
        RestAssured.baseURI="http://localhost:8080/";
        SessionFilter sf = new SessionFilter();

        given().header("Content-Type","application/json").body("{ \"username\": \"-- Select database type --\", \"password\": \"c09bbf8dfec0476c977ed9deff3fc548\" }")
                .log().all().filter(sf).when().post("rest/auth/1/session").then().log().all().extract().response().toString();
        Response rp=given().pathParam("id","MYT-25").log().all().header("Content-Type","application/json").body("{\n" +
                "    \"body\": \"testing completed\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Developers\"\n" +
                "    }\n" +
                "}").filter(sf).when().log().all().post("/rest/api/2/issue/{id}/comment");

        Response rps=given().pathParam("id","MYT-25").log().all().header("Content-Type","application/json").
                body("{\"update\":{\"Environment\":\"ws\"}}").filter(sf).when().log().all().post("/rest/api/2/issue/{id}");

        System.out.print(rps.getStatusCode());
    }
}

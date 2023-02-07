package org.main.api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.main.tools.Methods;
import org.main.tools.Payload;

import static io.restassured.RestAssured.given;

public class CreateSession {
    public static String createSession(SessionFilter session){
        String response;
        String cookie;

        RestAssured.baseURI = "http://localhost:8080";
        response= given()
                .header("Content-Type", "application/json")
                .body(Payload.getCredentials())
                .filter(session)
                .when().post("/rest/auth/1/session")
                .then().statusCode(200).extract().response().asPrettyString()
                ;
        System.out.println("Session created (logged In)\n"+response);
        JsonPath responseJson=Methods.convertToJson(response);
        cookie = Methods.getParameter(responseJson,"session.value");
        System.out.println("Cookie: " + cookie);

        return cookie;
   }
}

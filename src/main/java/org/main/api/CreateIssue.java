package org.main.api;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.main.tools.Methods;
import org.main.tools.Payload;

public class CreateIssue {

    public static String createIssue(SessionFilter session) {
        String addBookResponse;
        RestAssured.baseURI = "http://localhost:8080";

        addBookResponse = given()
                .header("Content-Type", "application/json")
                .body(Payload.getIssueBody())
                .filter(session)
                .when().post("/rest/api/2/issue")
                .then().statusCode(201).extract().asPrettyString()
                ;

        JsonPath addBookResponseJSON = Methods.convertToJson(addBookResponse);
        String issueKey = Methods.getParameter(addBookResponseJSON, "key");

        System.out.println("\nIssue " + issueKey + " created\n" + addBookResponse);

        return issueKey;
    }
}

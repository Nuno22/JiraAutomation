package org.main.api;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class DeleteIssue {
    public static void deleteIssue(SessionFilter session, String issueID) {

        RestAssured.baseURI = "http://localhost:8080";
        given()
                .header("Content-Type", "application/json")
                .pathParam("id",issueID)
                .filter(session)
                .when().delete("/rest/api/2/issue/{id}")
                .then().statusCode(204).extract().response().asPrettyString()
        ;

        System.out.println("\nDeleted issue: " + issueID);
    }
}

package org.main.api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.main.tools.Methods;
import org.main.tools.Payload;

import static io.restassured.RestAssured.given;

public class AddComment {

    public static String addComment(SessionFilter session, String issueID) {
        String response;
        String commentID;
        RestAssured.baseURI = "http://localhost:8080";
        response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", issueID)
                .body(Payload.getCommentBody())
                .filter(session)
                .when().post("/rest/api/2/issue/{id}/comment")
                .then().statusCode(201).extract().asPrettyString()
        ;
        commentID = Methods.getParameter(Methods.convertToJson(response), "id");
        System.out.println("\nComment added to Issue: " + issueID + "\n" + response);
        return commentID;
    }
}

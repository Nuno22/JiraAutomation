package org.main.api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import java.io.File;

import static io.restassured.RestAssured.given;

public class AddAttachmentToIssue {

    public static void addAttachmentToIssue(SessionFilter session, String issueID){
        String response;
        File file =
                new File("C:\\Users\\nunom\\Documents\\Udemy\\jiraAutomation\\src\\main\\java\\org\\main\\files\\file.txt");
        System.out.println(file.exists());
        RestAssured.baseURI = "http://localhost:8080";
        response = given()
                .header("X-Atlassian-Token", "no-check")
                .header("Content-Type", "multipart/form-data")
                .multiPart(file)
                .pathParam("id", issueID)
                .filter(session)
                .when().post("api/2/issue/{id}/attachments")
                .then().statusCode(200).extract().asPrettyString()
        ;
        System.out.println("\nComment added to Issue: " + issueID + "\n" + response);
    }
}

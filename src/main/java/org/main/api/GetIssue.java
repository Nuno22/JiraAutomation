package org.main.api;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.main.tools.Methods;
import org.main.tools.Payload;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetIssue {

    public static void getIssueValidateComment(SessionFilter session, String issueID, String commentId){
        String issueDetails;
        int commentsCount;

        issueDetails=given().filter(session)
                .pathParam("key", issueID)
                .queryParam("fields", "comment")
                .when().get("/rest/api/2/issue/{key}")
                .then().extract().response().asPrettyString();
        System.out.println(issueDetails);

        JsonPath js1 =new JsonPath(issueDetails);
        commentsCount= js1.getInt("fields.comment.comments.size()");
        for(int i = 0 ; i < commentsCount; i++) {
            String commentIdIssue =js1.get("fields.comment.comments["+i+"].id").toString();

            if (commentIdIssue.equalsIgnoreCase(commentId)) {
                String message= js1.get("fields.comment.comments["+i+"].body").toString();
                String expectedMsg = Methods.getParameter(Methods.convertToJson(Payload.getCommentBody()), "body");
                Assert.assertEquals(message, expectedMsg);
            }
        }
    }
}


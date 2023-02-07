package org.main;

import io.restassured.filter.session.SessionFilter;
import org.main.api.*;

public class Main {
    public static void main(String[] args) {
        SessionFilter session = new SessionFilter();
        String cookie;
        String issueID;
        String commentID;


        cookie = CreateSession.createSession(session);
        issueID = CreateIssue.createIssue(session);
        commentID = AddComment.addComment(session,issueID);
        //DeleteIssue.deleteIssue(session,issueID);
        //AddAttachmentToIssue.addAttachmentToIssue(session,issueID);
        GetIssue.getIssueValidateComment(session, issueID, commentID);
    }
}


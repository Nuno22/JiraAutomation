package org.main.tools;

public class Payload {
    public static String getCredentials() {
        String payload;
        payload =
                "{ \n" +
                "    \"username\": \"nuno22\", \n" +
                "    \"password\": \"password\" \n" +
                "}";
        return payload;
    }

    public static String getIssueBody(){
        String body;
        body =
                "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"RSA\"\n" +
                "        },\n" +
                "        \"summary\": \"Issue 3 test!!!\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        return body;
    }

    public static String getCommentBody(){
        String comment =
                "{\n" +
                        "    \"body\": \"This is a new comment\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}";
        return comment;
    }
}

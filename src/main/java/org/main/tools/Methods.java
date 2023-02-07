package org.main.tools;

import io.restassured.path.json.JsonPath;

public class Methods {
        public static JsonPath convertToJson(String str) {
            JsonPath json;
            json = new JsonPath(str);
            return json;
        }
        public static String getParameter(JsonPath json, String prm) {
            String str;
            str = json.getString(prm);
            return str;
        }
}

package org.gfg;

public class ResponseObject {
    private int statusCode;
    private String jsonResponse;

    private ResponseObject(){
    }

    public static ResponseObject createResponseObject(int statusCode, String jsonResponse) {
        ResponseObject resObj = new ResponseObject();
        resObj.setStatusCode(statusCode);
        resObj.setJsonResponse(jsonResponse);
        return resObj;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "statusCode='" + statusCode + '\'' +
                ", jsonResponse='" + jsonResponse + '\'' +
                '}';
    }
}

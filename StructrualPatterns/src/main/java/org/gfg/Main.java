package org.gfg;


import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResponseObject resObjOne = HttpFacade.sendHttpGETRequest("https://reqres.in/api/users?page=2");
        System.out.println(resObjOne);


        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("name", "morpheus"));
        params.add(new BasicNameValuePair("job", "leader"));
        ResponseObject resObjTwo = HttpFacade.sendHttpPOSTRequest("https://reqres.in/api/users", params);
        System.out.println(resObjTwo);

        ResponseObject resObjThree = HttpFacade.sendHttpPUTRequest("https://reqres.in/api/users/2", params);
        System.out.println(resObjThree);

        ResponseObject resObjFour = HttpFacade.sendHttpPATCHRequest("https://reqres.in/api/users/2", params);
        System.out.println(resObjFour);

        ResponseObject resObjFive = HttpFacade.sendHttpDELETERequest("https://reqres.in/api/users/2");
        System.out.println(resObjFive);

    }
}
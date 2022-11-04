package org.gfg;


import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        ResponseObject resObj = HttpFacade.sendHttpGETRequest("https://reqres.in/api/users?page=2");
        System.out.println(resObj);


        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("param-1", "12345"));
        params.add(new BasicNameValuePair("param-2", "Hello!"));
        HttpFacade.sendHttpPOSTRequest("https://reqres.in/api/users", params);

    }
}
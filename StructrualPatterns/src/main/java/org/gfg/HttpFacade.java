package org.gfg;


import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class HttpFacade {

    public HttpFacade() {
    }

    static ResponseObject sendHttpGETRequest(String url) {
        HttpGet httpget = new HttpGet(url);
        return sendCRUD(httpget);
    }

    public static ResponseObject sendHttpPOSTRequest (String url, List < NameValuePair > params){
        try {
                HttpPost httppost = new HttpPost(url);
                httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                return sendCRUD(httppost);
        } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
        }
    }
    public static ResponseObject sendHttpPUTRequest (String url, List < NameValuePair > params) {
        try {
            HttpPut httpput = new HttpPut(url);
            httpput.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            return sendCRUD(httpput);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResponseObject sendHttpPATCHRequest (String url, List < NameValuePair > params) {
        try {
            HttpPatch httppatch = new HttpPatch (url);
            httppatch.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            return sendCRUD(httppatch);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResponseObject sendHttpDELETERequest (String url) {
        HttpDelete httpdelete = new HttpDelete(url);
        return sendCRUD(httpdelete);
    }

    private static ResponseObject sendCRUD (HttpRequestBase crudOperation){
        try {
                HttpClient httpclient = HttpClients.createDefault();
                HttpResponse response = httpclient.execute(crudOperation);
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();

                if (statusLine.getStatusCode() >= 200 && statusLine.getStatusCode() < 300) {
                    if (entity != null) {
                        try (InputStream instream = entity.getContent()) {
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            entity.writeTo(out);
                            String responseString = out.toString();
                            out.close();
                            return ResponseObject.createResponseObject(response.getStatusLine().getStatusCode(), responseString);
                        }
                    }
                    else{
                        return ResponseObject.createResponseObject(response.getStatusLine().getStatusCode(), "no content");

                    }
                } else {
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (IOException e) {
                throw new RuntimeException( "Run Time Exception" ,e);
            }
        }
}

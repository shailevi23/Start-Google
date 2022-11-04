package org.gfg;


import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class HttpFacade {

    public HttpFacade(){
    }

    static ResponseObject sendHttpGETRequest(String url) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                String responseString = out.toString();
                out.close();
                return ResponseObject.createResponseObject(response.getStatusLine().getStatusCode(), responseString);
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponseObject sendHttpPOSTRequest(String url, List<NameValuePair> params){
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        try{
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    entity.writeTo(out);
                    String responseString = out.toString();
                    return ResponseObject.createResponseObject(response.getStatusLine().getStatusCode(), responseString);
            }
        } catch (UnsupportedEncodingException | ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void postRequest(){}
    public void putRequest(){}
    public void patchRequest(){}
    public void deleteRequest(){}

    public ResponseObject
}

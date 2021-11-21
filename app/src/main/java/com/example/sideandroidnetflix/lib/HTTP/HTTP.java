package com.example.sideandroidnetflix.lib.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class HTTP {
    private static HttpURLConnection conn;
    private static URL url_;
    private static Charset charset = Charset.forName("UTF-8");

    public HTTP(HttpURLConnection conn, URL url, Charset charset)
    {
        this.conn = conn;
        this.url_ = url;
        this.charset = charset;
    }
    public static HTTP GET(String url, Header header, Parameter paramerter) throws IOException {
        url += paramerter.makeParameters();
        url_ = new URL(url);
        conn = (HttpURLConnection) url_.openConnection();
        conn.setRequestMethod("GET");
        header.setHeaders(conn);

        return new HTTP(conn, url_, charset);
    }

    public static HTTP POST(String url, Header header, Parameter paramerter, Data data) throws IOException {
        url += paramerter.makeParameters();
        url_ = new URL(url);
        conn = (HttpURLConnection) url_.openConnection();
        conn.setRequestMethod("POST");
        header.setHeaders(conn);

        // post
        conn.setDoOutput(true);

        // data 전송
        if(conn.getDoOutput()) {
            conn.getOutputStream().write(data.getBytes());
            conn.getOutputStream().flush();
            conn.getOutputStream().close();
        }

        return new HTTP(conn, url_, charset);
    }

    public HTTP setConnectTimeOut(int timeout)
    {
        conn.setConnectTimeout(timeout);
        return this;
    }

    public HTTP setReadTimeOut(int timeout)
    {
        conn.setReadTimeout(timeout);
        return this;
    }

    public HTTP setRedirect(boolean redirect)
    {
        conn.setInstanceFollowRedirects(redirect);
        return this;
    }


    public Response request() throws IOException {

        Response response = new Response();
        response.responseCode = conn.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
        String inputLine;
        StringBuffer res = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
        }
        in.close();
        response.text = res.toString();

        return response;
    }
}


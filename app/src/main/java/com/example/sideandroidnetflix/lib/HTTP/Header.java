package com.example.sideandroidnetflix.lib.HTTP;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class Header {
    private Map<String, String> headers;

    public Header()
    {
        headers = new HashMap<>();
    }

    public void set(String Key, String Value)
    {
        headers.put(Key, Value);
    }

    public String get(String Key)
    {
        return headers.get(Key);
    }

    public void erase(String Key)
    {
        if(headers.containsKey(Key)) headers.remove(Key);
    }

    public void setHeaders(HttpURLConnection conn)
    {
        for( Map.Entry<String, String> elem : headers.entrySet() ) {
            conn.setRequestProperty(elem.getKey(), elem.getValue());
        }
    }
}

package com.example.sideandroidnetflix.lib.HTTP;

import java.util.HashMap;
import java.util.Map;

public class Data {
    private Map<String, String> datas;

    public Data()
    {
        datas = new HashMap<>();
    }

    public void set(String Key, String Value)
    {
        datas.put(Key, Value);
    }

    public String get(String Key)
    {
        return datas.get(Key);
    }

    public void erase(String Key)
    {
        if(datas.containsKey(Key)) datas.remove(Key);
    }

    public byte[] getBytes()
    {
        String data = "";

        for( Map.Entry<String, String> elem : datas.entrySet() ){
            data += "&" + elem.getKey() + "=" + elem.getValue();
        }

        return data.getBytes();
    }
}

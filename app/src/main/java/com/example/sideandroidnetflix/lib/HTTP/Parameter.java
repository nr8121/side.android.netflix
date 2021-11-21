package com.example.sideandroidnetflix.lib.HTTP;

import java.util.HashMap;
import java.util.Map;

public class Parameter {

    private Map<String, String> params;

    public Parameter()
    {
        params = new HashMap<>();
    }

    public void set(String Key, String Value)
    {
        params.put(Key, Value);
    }

    public String get(String Key)
    {
        return params.get(Key);
    }

    public void erase(String Key)
    {
        if(params.containsKey(Key)) params.remove(Key);
    }

    public String makeParameters()
    {
        String parameter = "";
        for( Map.Entry<String, String> elem : params.entrySet() ){
            parameter += "&" + elem.getKey() + "=" + elem.getValue();
        }

        return parameter;
    }

}

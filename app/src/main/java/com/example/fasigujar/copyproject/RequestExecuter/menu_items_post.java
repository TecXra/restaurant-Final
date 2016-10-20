package com.example.fasigujar.copyproject.RequestExecuter;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mian Mohsin on 10/17/2016.
 */
public class menu_items_post extends StringRequest {
    private Map<String,String> params;
    public menu_items_post(String Id, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, Url.baseeUrl, listener, errorListener);
        params= new HashMap<>();
        params.put("Id",Id);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

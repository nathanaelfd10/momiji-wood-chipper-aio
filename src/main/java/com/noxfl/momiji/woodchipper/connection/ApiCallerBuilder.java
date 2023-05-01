package com.noxfl.momiji.woodchipper.connection;

import com.noxfl.momiji.woodchipper.connection.impl.ApiCallerImpl;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.util.HashMap;
import java.util.Map;

public interface ApiCallerBuilder {

    public ApiCallerBuilder byPost(String body);
    public ApiCallerBuilder byGet();
    public ApiCallerBuilder setHeaders(HashMap<String, String> headers);
    public ApiCallerImpl build();

}

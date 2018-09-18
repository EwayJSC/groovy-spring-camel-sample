package com.eway.common.util;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/20/16.
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static OkHttpClient client;

    public static void setClient(OkHttpClient client) {
        HttpUtil.client = client;
    }

    public static okhttp3.Response get(String url, Map<String, Object> headers) throws IOException {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet())
                builder.addHeader(header.getKey(), String.valueOf(header.getValue()));

        Request request = builder.build();

        okhttp3.Response response = client.newCall(request).execute();
        return response;
    }

    public static okhttp3.Response postApplicationJson(String url, Map<String, Object> headers, String json) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                builder.addHeader(header.getKey(), String.valueOf(header.getValue()));
            }

        Request request = builder.post(body).build();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println("Executed postApplicationJson");
        return response;
    }

    public static okhttp3.Response postForm(String url, Map<String, Object> headers, Map<String, Object> forms) throws IOException {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                builder.addHeader(header.getKey(), String.valueOf(header.getValue()));
            }

        FormBody.Builder formBodyBuidler = new FormBody.Builder();
        if (forms != null)
            for (Map.Entry<String, Object> form : forms.entrySet()) {
                formBodyBuidler.add(form.getKey(), String.valueOf(form.getValue()));
            }
        RequestBody body = formBodyBuidler.build();

        Request request = builder.post(body).build();
        okhttp3.Response response = client.newCall(request).execute();
        return response;
    }

    public static List<String> extractUrls(String text) {
        List<String> containedUrls = new ArrayList<>();
        // do not accept (); in url
        String urlRegex = "((ht|f)tp(s?):\\/\\/|www\\.)"
                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                + "[\\p{Alnum}.,%_=?&#\\-+\\[\\]\\*$~@!:/{}']*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find()) {
            containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }

        return containedUrls;
    }
}

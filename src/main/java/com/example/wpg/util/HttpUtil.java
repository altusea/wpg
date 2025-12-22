package com.example.wpg.util;

import kala.value.LazyValue;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpHost;

import java.io.IOException;

public class HttpUtil {

    static final LazyValue<CloseableHttpClient> HTTP_CLIENT = LazyValue.of(HttpClients::createDefault);

    static String getWithProxy(String url, HttpHost proxy) throws IOException {
        return Request.get(url)
                .viaProxy(proxy)
                .execute(HTTP_CLIENT.get())
                .returnContent()
                .asString();
    }
}

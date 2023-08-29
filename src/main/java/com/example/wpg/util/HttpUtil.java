package com.example.wpg.util;

import com.example.wpg.model.mo.OperatorMO;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * reference <a href="https://square.github.io/okhttp/recipes/">source</a>
 */
public class HttpUtil {

    public static <T> T syncGet(String url, Class<T> holderClazz) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body == null) return null;
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(body.string(), holderClazz);
        }
    }

    public static void main(String[] args) throws IOException {
        var url = "http://127.0.0.1:8888/";
        OperatorMO operator = syncGet(url, OperatorMO.class);
        System.out.println(operator);
    }
}

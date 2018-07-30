package com.tests.okhttp;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestServiceTest {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String url = "https://jsonplaceholder.typicode.com/todos/1";

    @Test
    public void serviceGetTest() {
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String str = response.body().string();
            assertThat(response.code(), is(200));
            System.out.println(str);
        } catch (Exception e) {
            throw new RuntimeException("Unable to connect to server due to: " + e.getMessage());
        }
    }
}

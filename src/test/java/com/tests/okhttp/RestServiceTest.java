package com.tests.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestServiceTest {

    private final OkHttpClient client = new OkHttpClient();
    private static final String URL = "https://jsonplaceholderwertyuioiuytrewertyuik.typicode.com/todos/1";

    @Test
    public void serviceGetTest() {
        Request request = new Request.Builder()
                .url(URL)
                .header("Content-Type", "application/json")
                .build();
        Response response = null;
        String str = null;
        try {
            response = client.newCall(request).execute();
            str = response.body().string();
            assertThat(response.code(), is(200));
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}

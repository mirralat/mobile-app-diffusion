package com.example.myapplication;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.util.EntityUtils;


public class API {
    public static void Controller(String input)
    {
        Map data = new HashMap<>();
        data = Prompt.createPrompt(input);
        JSONObject json_value = new JSONObject();
        json_value = DiffusionSend(data);
        BufferedImage image = decodeImage(json_value);
        // дальше отправить на фронт...

    }

    public static JSONObject DiffusionSend(Map payload)
    {
        String endpointUrl = "http://kjn5nb3viufvfju2t4xvyj7cojeaxjxl3fq3zseyj76b5bjkfmyq.remote.moe";
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost request = new HttpPost(new URI(endpointUrl));

            // Add parameters to the request body
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                NameValuePair pair = new BasicNameValuePair(key, value);
                request.setEntity(new UrlEncodedFormEntity(List.of(pair)));
            }

            // Execute the request and get the response
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                // Parse the response body as JSON
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Do something with the JSON response
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } finally {
                response.close();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }
}
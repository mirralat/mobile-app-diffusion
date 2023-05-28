package com.example.myapplication;

import android.graphics.Bitmap;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;

public class API{
    public static void Controller(String input)
    {
        Map<String, Object> data = Prompt.createPrompt(input);
        JSONObject json_value = new JSONObject();
        // json_value = DiffusionSend(data);
        String json_string = data.toString();
        Bitmap image = Decode.decodeImage(json_string);
    }

    public static void DiffusionSend(Map<String, Object> payload)
    {
        try{
            URL diffURL = new URL("http://kjn5nb3viufvfju2t4xvyj7cojeaxjxl3fq3zseyj76b5bjkfmyq.remote.moe");
            HttpURLConnection request = (HttpURLConnection) (diffURL.openConnection());
            request.setRequestMethod("POST");
            request.setDoOutput(true);
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> entry: payload.entrySet())
            {
                if (postData.length() != 0) {
                    postData.append("&");
                }

                String key = URLEncoder.encode(entry.getKey(), "UTF-8");
                String value = URLEncoder.encode(entry.getValue().toString(), "UTF-8");
                postData.append(key).append("=").append(value);
            }

            OutputStream outputStream = request.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(postData.toString());
            writer.flush();
            writer.close();

        } catch (MalformedURLException badurl)
        {
            return;
        }
        catch (IOException badio) {
            return;
        }
    }
}
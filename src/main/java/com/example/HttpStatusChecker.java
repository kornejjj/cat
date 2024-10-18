package com.example;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) {
        String checkedUrl = null;
        try {
            URI uri = new URI("https", "http.cat", "/"+code+".jpg", null);

            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("There is not image for HTTP status " + code);
            }

            checkedUrl =url.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkedUrl;
    }
}

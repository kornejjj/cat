package com.example;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpStatusImageDownloader {
    HttpStatusChecker checker=new HttpStatusChecker();
    public void downloadStatusImage(int code){
        if(checker.getStatusImage(code)==null){
            return;
        }
        try {
            URI uri = new URI("https", "http.cat", "/"+code+".jpg", null);

            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            BufferedImage newImage = ImageIO.read(connection.getInputStream());
            ImageIO.write(newImage, "jpg", new File("outputImage.jpg"));

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

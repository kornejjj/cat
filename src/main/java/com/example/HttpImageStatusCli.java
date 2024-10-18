package com.example;
import java.util.Scanner;

public class HttpImageStatusCli {
    HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
    public void askStatus(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter HTTP status code:");
        String enteredStatusCode = in.nextLine();

        Integer verifedStatusCode=checkStatusCode(enteredStatusCode);
        downloader.downloadStatusImage(verifedStatusCode);
    }
    private Integer checkStatusCode(String enteredStatusCode){
        if(enteredStatusCode.isEmpty()){
            throw new RuntimeException("Please enter valid number");
        }
        try {
            int statusCode = Integer.parseInt(enteredStatusCode.strip());
            return statusCode;
        } catch (Exception e) {
            throw new RuntimeException("Please enter valid number");
        }
    }
}

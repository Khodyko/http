package com.company.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        URL googleURL = new URL("http://google.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) googleURL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setUseCaches(true);
        System.out.println(httpURLConnection.getResponseCode());

        try (BufferedReader bu = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));) {
            while (bu.ready()) {
                System.out.println(bu.readLine());
            }
        }
        httpURLConnection.disconnect();

    }
}

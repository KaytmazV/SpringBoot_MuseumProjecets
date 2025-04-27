package com.volkankaytmaz.museumfrontend.service;

import com.google.gson.Gson;
import com.volkankaytmaz.museumfrontend.model.ArtWork;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ArtworkService {

    private static final String API_URL = "http://localhost:8080/api/artworks";

    // Get All Artworks
    public List<ArtWork> getArtworks() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // Read response
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        ArtWork[] artworks = new Gson().fromJson(reader, ArtWork[].class);

        reader.close();  // Bağlantıyı kapatıyoruz
        connection.disconnect(); // Bağlantıyı düzgün şekilde kapat

        return List.of(artworks);
    }

    // Create New ArtWork
    public void createArtWork(ArtWork artWork) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(API_URL, artWork, ArtWork.class);  // Yeni eseri backend'e gönder
    }
}

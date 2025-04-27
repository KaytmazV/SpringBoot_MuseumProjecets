package com.volkankaytmaz.museumfrontend.service;

import com.google.gson.Gson;
import com.volkankaytmaz.museumfrontend.model.ArtWork;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ArtworkService {

    private static final String API_URL = "http://localhost:8080/api/artworks";

    public List<ArtWork> getArtworks() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        ArtWork[] artworks = new Gson().fromJson(reader, ArtWork[].class);
        return List.of(artworks);
    }
}

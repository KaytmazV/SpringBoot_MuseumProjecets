package com.volkankaytmaz.museumfrontend;

import com.volkankaytmaz.museumfrontend.model.ArtWork;
import com.volkankaytmaz.museumfrontend.service.ArtworkService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.List;

public class AppWork extends Application {

    private ArtworkService artworkService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        artworkService = new ArtworkService();

        // Eserleri listeleme ekranı
        List<ArtWork> artworks = artworkService.getArtworks();
        ListView<String> listView = new ListView<>();
        for (ArtWork artwork : artworks) {
            listView.getItems().add(artwork.getName());
        }

        listView.setOnMouseClicked(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                ArtWork selectedArtwork = artworks.get(selectedIndex);
                playAudio(selectedArtwork.getAudioUrl());
            }
        });

        // Eser ekleme formu
        TextField nameField = new TextField();
        nameField.setPromptText("Eser Adı");

        TextArea descriptionArea = new TextArea();
        descriptionArea.setPromptText("Açıklama");

        TextField audioUrlField = new TextField();
        audioUrlField.setPromptText("Ses URL'si");

        Button addButton = new Button("Eser Ekle");
        addButton.setOnAction(event -> {
            String name = nameField.getText();
            String description = descriptionArea.getText();
            String audioUrl = audioUrlField.getText();

            // Yeni eseri backend'e gönder
            ArtWork newArtWork = new ArtWork();
            newArtWork.setName(name);
            newArtWork.setDescription(description);
            newArtWork.setAudioUrl(audioUrl);

            artworkService.createArtWork(newArtWork);  // Backend'e gönder

            nameField.clear();
            descriptionArea.clear();
            audioUrlField.clear();
        });

        // Layout
        Button addArtworkButton = new Button("Eser Ekle");
        addArtworkButton.setOnAction(event -> {
            Scene addArtworkScene = createAddArtworkScene(primaryStage);
            primaryStage.setScene(addArtworkScene);
        });

        VBox listBox = new VBox(10, listView, addArtworkButton);
        Scene scene = new Scene(listBox, 400, 400);

        primaryStage.setTitle("Museum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Scene createAddArtworkScene(Stage primaryStage) {
        // ArtWork ekleme formu
        TextField nameField = new TextField();
        nameField.setPromptText("Eser Adı");

        TextArea descriptionArea = new TextArea();
        descriptionArea.setPromptText("Açıklama");

        TextField audioUrlField = new TextField();
        audioUrlField.setPromptText("Ses URL'si");

        Button addButton = new Button("Eser Ekle");
        addButton.setOnAction(event -> {
            String name = nameField.getText();
            String description = descriptionArea.getText();
            String audioUrl = audioUrlField.getText();

            // Yeni eseri backend'e gönder
            ArtWork newArtWork = new ArtWork();
            newArtWork.setName(name);
            newArtWork.setDescription(description);
            newArtWork.setAudioUrl(audioUrl);

            artworkService.createArtWork(newArtWork);  // Backend'e gönder

            nameField.clear();
            descriptionArea.clear();
            audioUrlField.clear();
        });

        VBox vBox = new VBox(10, nameField, descriptionArea, audioUrlField, addButton);
        return new Scene(vBox, 400, 300);
    }

    private void playAudio(String audioUrl) {
        Media media = new Media(audioUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}

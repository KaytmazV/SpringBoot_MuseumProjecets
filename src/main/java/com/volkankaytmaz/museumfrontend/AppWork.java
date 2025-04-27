package com.volkankaytmaz.museumfrontend;

import com.volkankaytmaz.museumfrontend.model.ArtWork;
import com.volkankaytmaz.museumfrontend.service.ArtworkService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import java.util.List;

public class AppWork extends Application {

    private ArtworkService artworkService;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        artworkService = new ArtworkService();
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

        VBox vBox = new VBox(listView);
        Scene scene = new Scene(vBox, 300, 400);
        primaryStage.setTitle("Museum");
        primaryStage.setScene(scene);
        primaryStage.show();
        }


    private void playAudio(String audioUrl) {
        Media media = new Media(audioUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    }

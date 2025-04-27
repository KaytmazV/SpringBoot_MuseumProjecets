package com.volkankaytmaz.museumfrontend.model;

public class ArtWork {

    private Long id;
    private String name;
    private String description;
    private String audioUrl;

    // Parametresiz yapıcı
    public ArtWork() {
    }

    // Parametreli yapıcı
    public ArtWork(Long id, String name, String description, String audioUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.audioUrl = audioUrl;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
}

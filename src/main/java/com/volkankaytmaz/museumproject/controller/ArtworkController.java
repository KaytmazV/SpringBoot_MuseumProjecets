package com.volkankaytmaz.museumproject.controller;


import com.volkankaytmaz.museumproject.entity.ArtWork;
import com.volkankaytmaz.museumproject.service.ArtworkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
@CrossOrigin
public class ArtworkController {

    private final ArtworkService artworkService;


    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }
    @GetMapping
    public List<ArtWork> getAllArtworks() {
        return artworkService.getAllArtworks();
    }
    @GetMapping("/{id}")
    public ArtWork getArtworkById(@PathVariable Long id) {
        return artworkService.getArtworkById(id);
    }
}

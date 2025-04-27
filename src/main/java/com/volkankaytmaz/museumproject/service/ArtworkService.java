package com.volkankaytmaz.museumproject.service;

import com.volkankaytmaz.museumproject.entity.ArtWork;
import com.volkankaytmaz.museumproject.repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {
private final ArtworkRepository artworkRepository;


    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public List<ArtWork> getAllArtworks() {
        return artworkRepository.findAll();
    }

    public ArtWork getArtworkById(Long id) {
        return artworkRepository.findById(id).orElse(null);
    }
}

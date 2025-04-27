package com.volkankaytmaz.museumbackend.repository;

import com.volkankaytmaz.museumbackend.entity.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<ArtWork, Long> {
}

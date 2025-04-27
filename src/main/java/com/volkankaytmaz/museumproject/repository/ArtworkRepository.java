package com.volkankaytmaz.museumproject.repository;

import com.volkankaytmaz.museumproject.entity.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<ArtWork, Long> {
}

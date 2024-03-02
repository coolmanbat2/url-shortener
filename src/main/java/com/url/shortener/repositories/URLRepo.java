package com.url.shortener.repositories;

import com.url.shortener.models.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface URLRepo extends JpaRepository<URL, Long> {
    URL findByShortURLCode(String shortURLCode);

    boolean existsByShortURLCode(String shortURLCode);
}
